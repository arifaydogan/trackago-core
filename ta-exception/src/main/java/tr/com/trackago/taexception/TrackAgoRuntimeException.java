package tr.com.trackago.taexception;

/**
 * Sistemin kendine ozgu verdigi uygulama calistirma hatasidir.
 *
 * @author arifaydogan
 */
public class TrackAgoRuntimeException extends TrackAgoException {

    protected static String TYPE = "0";

    public TrackAgoRuntimeException(String message, String moduleIdentifier, String processIdentifier) {
        super(message, TYPE, moduleIdentifier, processIdentifier);
    }

    public TrackAgoRuntimeException(String message, Throwable cause, String moduleIdentifier,
                                    String processIdentifier) {
        super(message, cause, TYPE, moduleIdentifier, processIdentifier);
    }

    public TrackAgoRuntimeException(Throwable cause, String moduleIdentifier, String processIdentifier) {
        super(cause, TYPE, moduleIdentifier, processIdentifier);
    }

    public TrackAgoRuntimeException(String message, Throwable cause, boolean enableSuppression,
                                    boolean writableStackTrace, String moduleIdentifier, String processIdentifier) {
        super(message, cause, enableSuppression, writableStackTrace, TYPE, moduleIdentifier,
                processIdentifier);
    }

    public TrackAgoRuntimeException(String message, String moduleIdentifier, String processIdentifier, Object value) {
        super(message, TYPE, moduleIdentifier, processIdentifier, value);
    }

    public TrackAgoRuntimeException(String message, Object value) {
        super(message, TYPE, value);
    }
}
