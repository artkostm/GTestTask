package by.geotesttask.res;

import java.util.ResourceBundle;

/**
 * Created by Artsiom on 1/19/2015.
 */
public enum Constants {
    API_KEY, QP_LOCATION, QP_TIMESTAMP, QP_KEY, DELIMITER, SKIP_HEADER,
    HOST, SCHEMA, PATH;

    public static final String STATUS_OK = "OK";
    public static final String STATUS_FAILED = "FAILED";
    public static final String EMPTY_STR = "";
    public static final String Q_DELIMITER = ",";

    private ResourceBundle bundle;

    private Constants(){
        bundle = ResourceBundle.getBundle("application");
    }

    public String get(){
        String prop = bundle.getString(this.toString().toLowerCase());
        return prop;
    }
}
