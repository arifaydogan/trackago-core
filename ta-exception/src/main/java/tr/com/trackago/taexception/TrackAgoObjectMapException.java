package tr.com.trackago.taexception;


public class TrackAgoObjectMapException extends TrackAgoRuntimeException {

    public TrackAgoObjectMapException(Exception e) {
        super("Mapperda bir hata oluştu", e.getCause());
    }
}
