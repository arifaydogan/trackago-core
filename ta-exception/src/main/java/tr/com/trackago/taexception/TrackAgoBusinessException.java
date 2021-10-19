package tr.com.trackago.taexception;

/**
 * Sistemin kendine ozgu verdigi uygulama calistirma hatasidir.
 *
 * @author arifaydogan
 */
public class TrackAgoBusinessException extends TrackAgoRuntimeException {

    protected static String TYPE = "1";

    public TrackAgoBusinessException(String message, String moduleIdentifier, String processIdentifier) {
        super(message, moduleIdentifier, processIdentifier);
    }

    public TrackAgoBusinessException(String message, Throwable cause, String moduleIdentifier, String processIdentifier) {
        super(message, cause, moduleIdentifier, processIdentifier);
    }

    public TrackAgoBusinessException(Throwable cause, String moduleIdentifier, String processIdentifier) {
        super(cause, moduleIdentifier, processIdentifier);
    }

    public TrackAgoBusinessException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace, String moduleIdentifier, String processIdentifier) {
        super(message, cause, enableSuppression, writableStackTrace, moduleIdentifier,
                processIdentifier);
    }

    public TrackAgoBusinessException(String message, Object value) {
        super(message, value);
    }

}
