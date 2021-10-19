package tr.com.trackago.talogging;

import org.slf4j.Logger;

public class TrackAgoLogger {

    private final Logger logger;

    TrackAgoLogger(Logger logger) {
        this.logger = logger;
    }

    public void info(String message, Throwable exception) {
        logger.info(message, exception);
    }

    public void info(String message) {
        logger.info(message);
    }

    public void info(String message, Object... args) {
        logger.info(message, args);
    }

    public void error(String message, Throwable exception) {
        logger.error(message, exception);
    }

    public void error(String message) {
        logger.error(message);
    }

    public void error(String message, Object... args) {
        logger.error(message, args);
    }

    public void warn(String message) {
        logger.warn(message);
    }

    public void warn(String message, Throwable exception) {
        logger.warn(message, exception);
    }

    public void debug(String message) {
        logger.debug(message);
    }

    public void debug(String message, Object... args) {
        logger.debug(message, args);
    }

    public Logger getLogger() {
        return logger;
    }
}
