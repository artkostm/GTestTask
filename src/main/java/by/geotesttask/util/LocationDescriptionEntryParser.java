package by.geotesttask.util;

import by.geotesttask.errors.LogicalException;
import by.geotesttask.model.LocationDescription;
import com.google.maps.model.LatLng;
import com.googlecode.jcsv.reader.CSVEntryParser;

/**
 * Created by Artsiom on 1/19/2015.
 */
public final class LocationDescriptionEntryParser implements CSVEntryParser<LocationDescription>{

    @Override
    public LocationDescription parseEntry(String... data){
        if(data.length < 2){
            return new LocationDescription(0,0);
        }
        double lat = Double.parseDouble(data[0]);
        double lng = Double.parseDouble(data[1]);
        LocationDescription ld = new LocationDescription(lat, lng);
        return ld;
    }
}
