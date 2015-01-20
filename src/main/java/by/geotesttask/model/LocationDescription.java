package by.geotesttask.model;

import com.google.maps.model.LatLng;

import java.util.TimeZone;

/**
 * Created by Artsiom on 1/19/2015.
 */
public class LocationDescription {

    private LatLng latLng;
    private TimeZone timeZone;
    private String status;

    public LocationDescription(LatLng latLng, TimeZone timeZone) {
        this.latLng = latLng;
        this.timeZone = timeZone;
    }

    public LocationDescription(double lat, double lng) {
        this.latLng = new LatLng(lat, lng);
    }

    public LatLng getLatLng() {
        return latLng;
    }

    public void setLatLng(LatLng latLng) {
        this.latLng = latLng;
    }

    public TimeZone getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LocationDescription that = (LocationDescription) o;

        if (latLng != null ? !latLng.equals(that.latLng) : that.latLng != null) return false;
        if (timeZone != null ? !timeZone.equals(that.timeZone) : that.timeZone != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = latLng != null ? latLng.hashCode() : 0;
        result = 31 * result + (timeZone != null ? timeZone.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "LocationDescription{" +
                "latLng=" + latLng +
                ", timeZone=" + timeZone +
                '}';
    }
}
