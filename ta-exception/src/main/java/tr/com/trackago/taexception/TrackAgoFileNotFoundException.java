package tr.com.trackago.taexception;

/**
 * Sistemde dosya islemlerinde, dosyanin bulunmamasi durumda atilan hatadir.
 *
 * @author bocal
 */
public class TrackAgoFileNotFoundException extends TrackAgoIOException {

    public TrackAgoFileNotFoundException(String message, String moduleIdentifier,
                                         String processIdentifier) {
        super(message, moduleIdentifier, processIdentifier);
    }

    public TrackAgoFileNotFoundException(String message, Throwable cause, String moduleIdentifier,
                                         String processIdentifier) {
        super(message, cause, moduleIdentifier, processIdentifier);
    }

    public TrackAgoFileNotFoundException(Throwable cause, String moduleIdentifier,
                                         String processIdentifier) {
        super(cause, moduleIdentifier, processIdentifier);
    }

    public TrackAgoFileNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                         boolean writableStackTrace, String moduleIdentifier, String processIdentifier) {
        super(message, cause, enableSuppression, writableStackTrace, moduleIdentifier,
                processIdentifier);
    }
}
