package by.geotesttask.errors;

/**
 * Created by Artsiom on 1/19/2015.
 */
public class TechnicalException extends Exception {
    public TechnicalException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public TechnicalException(Throwable cause) {
        super(cause);
    }

    public TechnicalException() {
    }

    public TechnicalException(String message) {
        super(message);
    }

    public TechnicalException(String message, Throwable cause) {
        super(message, cause);
    }
}
