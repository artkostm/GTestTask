package by.geotesttask.logic;

import by.geotesttask.errors.LogicalException;
import by.geotesttask.errors.TechnicalException;
import by.geotesttask.model.LocationDescription;
import by.geotesttask.service.TimeZoneService;
import by.geotesttask.util.CSVUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.List;

/**
 * Created by Artsiom on 1/19/2015.
 */
public class TestTaskLogic {

    private static final Logger logger = LoggerFactory.getLogger(TestTaskLogic.class);

    /**
     *
     * @param args - path to the csv files
     * @throws LogicalException
     */
    public static void performTask(String[] args) throws LogicalException {
        if(args.length < 2){
            throw new LogicalException("Do not set the path to the csv files");
        }
        try {
            List<LocationDescription> lds = CSVUtil.readCSVFile(args[0]);
            TimeZoneService service = new TimeZoneService();
            lds = service.execute(lds);
            CSVUtil.writeCSVFile(args[1], lds);
        }catch (TechnicalException ex){
            logger.error(ex.getLocalizedMessage(), ex);
        }
        logger.info("Finish...");
    }
}
