package tr.com.trackago.taexception;

/**
 * Sistemde dosya uzerinde okuma ve yazma islemlerinden olusabilecek hatalari bildirmede
 * kullanilacak siniftir.
 *
 * @author bocal
 */
public class TrackAgoIOException extends TrackAgoException {

    private static final String TYPE = "0";

    public TrackAgoIOException(String message, String moduleIdentifier, String processIdentifier) {
        super(message, TYPE, moduleIdentifier, processIdentifier);
    }

    public TrackAgoIOException(String message, Throwable cause, String moduleIdentifier,
                               String processIdentifier) {
        super(message, cause, TYPE, moduleIdentifier, processIdentifier);
    }

    public TrackAgoIOException(Throwable cause, String moduleIdentifier, String processIdentifier) {
        super(cause, TYPE, moduleIdentifier, processIdentifier);
    }

    public TrackAgoIOException(String message, Throwable cause, boolean enableSuppression,
                               boolean writableStackTrace, String moduleIdentifier, String processIdentifier) {
        super(message, cause, enableSuppression, writableStackTrace, TYPE, moduleIdentifier,
                processIdentifier);
    }

}
