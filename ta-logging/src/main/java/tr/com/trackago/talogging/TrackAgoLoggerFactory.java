package tr.com.trackago.talogging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TrackAgoLoggerFactory {

    public static TrackAgoLogger getLogger(Class clazz) {
        final Logger logger = LoggerFactory.getLogger(clazz);
        return new TrackAgoLogger(logger);
    }
}
