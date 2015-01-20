package by.geotesttask.service;

import by.geotesttask.model.LocationDescription;
import by.geotesttask.res.Constants;
import com.google.maps.GeoApiContext;
import com.google.maps.PendingResult;
import com.google.maps.TimeZoneApi;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.TimeZone;

/**
 * Created by Artsiom on 1/19/2015.
 */
public class TimeZoneService {

    private GeoApiContext context;

    private static final Logger logger = LoggerFactory.getLogger(TimeZoneService.class);

    public TimeZoneService() {
        context = new GeoApiContext().setApiKey(Constants.API_KEY.get());
    }

    /**
     *
     * @param lds - crude list with locations
     * @return ready list with locations and time zones
     */
    public List<LocationDescription> execute(List<LocationDescription> lds){
        for(LocationDescription ld : lds){
            PendingResult<TimeZone> result = TimeZoneApi.getTimeZone(context, ld.getLatLng());
            TimeZone tz = null;
            try {
                tz = result.await();
            } catch (Exception e) {
                logger.error(e.getLocalizedMessage(), e);
            }
            ld.setTimeZone(tz);
        }
        return lds;
    }
}
