package by.geotesttask.util;

import by.geotesttask.model.LocationDescription;
import by.geotesttask.res.Constants;
import com.googlecode.jcsv.writer.CSVEntryConverter;

import java.util.TimeZone;

/**
 * Created by Artsiom on 1/19/2015.
 */
public final class LocationDescriptionEntryConverter implements CSVEntryConverter<LocationDescription> {

    @Override
    public String[] convertEntry(LocationDescription ld) {
        return new String[]{
                String.valueOf(ld.getLatLng().lat),
                String.valueOf(ld.getLatLng().lng),
                String.valueOf(
                        (ld.getTimeZone() == null ?
                                Constants.EMPTY_STR : ld.getTimeZone().getDSTSavings())
                ),
                String.valueOf(
                        (ld.getTimeZone() == null ?
                                Constants.EMPTY_STR : ld.getTimeZone().getRawOffset())
                ),
                (ld.getTimeZone() == null ? Constants.EMPTY_STR : ld.getTimeZone().getID()),
                (ld.getTimeZone() == null ? Constants.EMPTY_STR : ld.getTimeZone().getDisplayName()),
                (ld.getTimeZone() == null ? Constants.STATUS_FAILED : Constants.STATUS_OK)
        };
    }
}
