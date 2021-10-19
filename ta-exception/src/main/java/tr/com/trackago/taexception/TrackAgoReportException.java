package tr.com.trackago.taexception;

/**
 * Sistemde raporlama sirasinda olusan hatadir.
 *
 * @author bocal
 */
public class TrackAgoReportException extends TrackAgoRuntimeException {

    public TrackAgoReportException(String message, String moduleIdentifier,
                                   String processIdentifier) {
        super(message, moduleIdentifier, processIdentifier);
    }

    public TrackAgoReportException(String message, Throwable cause, String moduleIdentifier,
                                   String processIdentifier) {
        super(message, cause, moduleIdentifier, processIdentifier);
    }

    public TrackAgoReportException(Throwable cause, String moduleIdentifier,
                                   String processIdentifier) {
        super(cause, moduleIdentifier, processIdentifier);
    }

    public TrackAgoReportException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace, String moduleIdentifier, String processIdentifier) {
        super(message, cause, enableSuppression, writableStackTrace, moduleIdentifier,
                processIdentifier);
    }
}
