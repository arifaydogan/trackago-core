package tr.com.trackago.taexception;

/**
 * Sistemin authenticate sırasında kisi dogrulayamama durumunda calistirma hatasidir.
 *
 * @author arifaydogan
 */
public class TrackAgoAuthException extends TrackAgoRuntimeException {

    protected static String TYPE = "1";

    public TrackAgoAuthException(String message, String moduleIdentifier, String processIdentifier) {
        super(message, moduleIdentifier, processIdentifier);
    }

    public TrackAgoAuthException(String message, Throwable cause, String moduleIdentifier, String processIdentifier) {
        super(message, cause, moduleIdentifier, processIdentifier);
    }

    public TrackAgoAuthException(Throwable cause, String moduleIdentifier, String processIdentifier) {
        super(cause, moduleIdentifier, processIdentifier);
    }

    public TrackAgoAuthException(String message, Throwable cause, boolean enableSuppression,
                                 boolean writableStackTrace, String moduleIdentifier, String processIdentifier) {
        super(message, cause, enableSuppression, writableStackTrace, moduleIdentifier,
                processIdentifier);
    }

    public TrackAgoAuthException(String message, Object value) {
        super(message, value);
    }

}
