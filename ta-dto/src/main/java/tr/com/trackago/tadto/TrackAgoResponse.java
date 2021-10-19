package tr.com.trackago.tadto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TrackAgoResponse<T> {

    private T body;
    private List<String> messages;
    private List<String> warnings;
    private ResponseStatus responseStatus;
    private long responseDuration;


    public T getBody() {
        return body;
    }

    public List<String> getMessages() {
        return messages;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public List<String> getWarnings() {
        return warnings;
    }

    public long getResponseDuration() {
        return responseDuration;
    }

    public void setResponseDuration(long responseDuration) {
        this.responseDuration = responseDuration;
    }

    public static <T> Builder<T> builder() {
        return new Builder<>();
    }

    public static class Builder<T> {

        private TrackAgoResponse<T> instance;

        private Builder() {
            instance = new TrackAgoResponse<T>();
            instance.messages = new ArrayList<>();
            instance.warnings = new ArrayList<>();
        }


        public Builder<T> body(T body) {
            this.instance.body = body;
            return this;
        }


        public Builder<T> addMessage(String message) {
            this.instance.messages.add(message);
            return this;
        }

        public Builder<T> addMessages(Collection<String> messages) {
            this.instance.messages.addAll(messages);
            return this;
        }

        public Builder<T> addWarning(String message) {
            this.instance.warnings.add(message);
            return this;
        }

        public Builder<T> addWarnings(Collection<String> messages) {
            this.instance.warnings.addAll(messages);
            return this;
        }


        public Builder<T> success() {
            this.instance.responseStatus = ResponseStatus.SUCCESS;
            return this;
        }

        public Builder<T> validationFail() {
            this.instance.responseStatus = ResponseStatus.VALIDATON_FAIL;
            return this;
        }

        public Builder<T> error() {
            this.instance.responseStatus = ResponseStatus.ERROR;
            return this;
        }

        public Builder<T> warning() {
            this.instance.responseStatus = ResponseStatus.WARNING;
            return this;
        }

        public Builder<T> unauthorized() {
            this.instance.responseStatus = ResponseStatus.UNAUTHORIZED;
            return this;
        }

        public Builder<T> unreachableExternalServer() {
            this.instance.responseStatus = ResponseStatus.UNREACHABLE_EXTERNAL_SERVICE;
            return this;
        }

        public TrackAgoResponse<T> buildInstance() {
            return this.instance;
        }
    }

    public  enum ResponseStatus {
        SUCCESS,
        VALIDATON_FAIL,
        UNAUTHORIZED,
        ERROR,
        UNREACHABLE_EXTERNAL_SERVICE,
        WARNING
    }
}
