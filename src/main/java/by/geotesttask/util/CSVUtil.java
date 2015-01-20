package by.geotesttask.util;

import by.geotesttask.errors.TechnicalException;
import by.geotesttask.model.LocationDescription;
import by.geotesttask.res.Constants;
import com.googlecode.jcsv.CSVStrategy;
import com.googlecode.jcsv.reader.CSVReader;
import com.googlecode.jcsv.reader.internal.CSVReaderBuilder;
import com.googlecode.jcsv.writer.CSVWriter;
import com.googlecode.jcsv.writer.internal.CSVWriterBuilder;

import java.io.*;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Artsiom on 1/19/2015.
 */
public final class CSVUtil {

    private CSVUtil(){}

    public static final CSVStrategy DEFAULT_STRATEGY
                                        = new CSVStrategy(Constants.DELIMITER.get().charAt(0), '"', '#',
                                                          Boolean.parseBoolean(Constants.SKIP_HEADER.get()), true);

    /**
     *
     * @return path to the csv file
     */
    public static String getCSVFilePath(){
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        scanner.close();
        return path;
    }

    /**
     *
     * @param path to the csv file
     * @return a list of locations
     * @throws TechnicalException
     */
    public static List<LocationDescription> readCSVFile(String path) throws TechnicalException{
        CSVReader<LocationDescription> timeZoneReader = null;
        try {
            Reader reader = new FileReader(path);
            timeZoneReader = new CSVReaderBuilder<LocationDescription>(reader)
                    .entryParser(new LocationDescriptionEntryParser())
                    .strategy(DEFAULT_STRATEGY).build();
            List<LocationDescription> tzs = timeZoneReader.readAll();
            return tzs;
        }catch (IOException ex){
            throw new TechnicalException(ex);
        }finally{
            if(timeZoneReader != null){
                timeZoneReader.close();
            }
        }
    }

    /**
     *
     * @param path to the csv file
     * @param tzs
     * @throws TechnicalException
     */
    public static void writeCSVFile(String path, List<LocationDescription> tzs) throws TechnicalException{
        CSVWriter<LocationDescription> timeZoneWriter = null;
        try {
            Writer writer = new FileWriter(path);
            timeZoneWriter = new CSVWriterBuilder<LocationDescription>(writer)
                    .entryConverter(new LocationDescriptionEntryConverter())
                    .strategy(DEFAULT_STRATEGY).build();
            timeZoneWriter.writeAll(tzs);
            timeZoneWriter.flush();
        }catch (IOException ex){
            throw new TechnicalException(ex);
        }finally{
            if(timeZoneWriter != null){
                timeZoneWriter.close();
            }
        }
    }
}
