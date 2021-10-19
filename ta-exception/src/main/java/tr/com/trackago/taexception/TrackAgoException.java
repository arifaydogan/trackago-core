package tr.com.trackago.taexception;

import java.util.Objects;

/**
 * Sistemin kendine ait temel hata sinifidir.
 *
 * @author arifaydogan
 */
public class TrackAgoException extends Exception {

    private String type;

    private String moduleIdentifier;

    private String processIdentifier;

    private Object value;

    public TrackAgoException(String message, String type, String moduleIdentifier,
                             String processIdentifier) {
        super(message);
        this.type = type;
        this.moduleIdentifier = moduleIdentifier;
        this.processIdentifier = processIdentifier;
    }

    public TrackAgoException(String message, Throwable cause, String type, String moduleIdentifier,
                             String processIdentifier) {
        super(message, cause);
        this.type = type;
        this.moduleIdentifier = moduleIdentifier;
        this.processIdentifier = processIdentifier;
    }

    public TrackAgoException(Throwable cause, String type, String moduleIdentifier,
                             String processIdentifier) {
        super(cause);
        this.type = type;
        this.moduleIdentifier = moduleIdentifier;
        this.processIdentifier = processIdentifier;
    }

    public TrackAgoException(String message, Throwable cause, boolean enableSuppression,
                             boolean writableStackTrace, String type, String moduleIdentifier, String processIdentifier) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.type = type;
        this.moduleIdentifier = moduleIdentifier;
        this.processIdentifier = processIdentifier;
    }

    public TrackAgoException(String message, String type, String moduleIdentifier,
                             String processIdentifier, Object value) {
        super(message);
        this.type = type;
        this.moduleIdentifier = moduleIdentifier;
        this.processIdentifier = processIdentifier;
        this.value = value;
    }

    public TrackAgoException(String message, String type, Object value) {
        super(message);
        this.type = type;
        this.value = value;
    }

    public String getType() {
        return type;
    }

    public String getModuleIdentifier() {
        return moduleIdentifier;
    }

    public String getProcessIdentifier() {
        return processIdentifier;
    }

    public String getTokiCode() {

        if (!Objects.isNull(value))
            return value.toString();

        return moduleIdentifier + type + processIdentifier;
    }

    public Object getValue() {
        return value;
    }

}
