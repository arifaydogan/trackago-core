package tr.com.trackago.taexception.handler;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.exception.ExceptionUtils;
import tr.com.trackago.tadto.TrackAgoResponse;
import tr.com.trackago.taexception.TrackAgoAuthException;
import tr.com.trackago.taexception.TrackAgoBusinessException;
import tr.com.trackago.taexception.TrackAgoException;

import java.lang.reflect.InvocationTargetException;
import java.rmi.RemoteException;

public abstract class TrackAgoExceptionHandler {

    private ObjectMapper objectMapper;

    protected ObjectMapper objectMapperInstance() {
        if (objectMapper == null)
            objectMapper = new ObjectMapper();

        return objectMapper;
    }


    public TrackAgoResponse<String> handleTrackAgoBusinessExceptions(TrackAgoBusinessException ex) throws JsonProcessingException {

        TrackAgoResponse response = TrackAgoResponse.<String>builder()
                .body(null)
                .validationFail()
                .addWarning(ex.getModuleIdentifier() + "." + ex.getProcessIdentifier() + " : " + ex.getMessage())
                .buildInstance();

        return response;
    }


    public TrackAgoResponse<String> handleIllegalAccessExceptions(IllegalAccessException ex) throws JsonProcessingException {

        TrackAgoResponse response = TrackAgoResponse.<String>builder()
                .body(null)
                .error()
                .addMessage(ex.getMessage())
                .buildInstance();
        String responseStr = objectMapperInstance().writeValueAsString(response);
        notifySendableExceptions(ex, responseStr);

        return response;
    }

    public TrackAgoResponse<String> handleAuthenticationExceptions(TrackAgoAuthException ex) throws JsonProcessingException {
        TrackAgoResponse response = TrackAgoResponse.<String>builder()
                .body(null)
                .unauthorized()
                .addMessage(ex.getMessage())
                .buildInstance();
        String responseStr = objectMapperInstance().writeValueAsString(response);
        notifySendableExceptions(ex, responseStr);
        return response;
    }


    public TrackAgoResponse<String> handleInvocationTargetExceptions(InvocationTargetException ex) throws JsonProcessingException {
        String messages = ex.getTargetException().getMessage();
        String warnings = "";
        if (ex.getTargetException() instanceof TrackAgoBusinessException) {
            TrackAgoBusinessException businessException = (TrackAgoBusinessException) ex.getTargetException();
            warnings = businessException.getModuleIdentifier() + "." + businessException.getProcessIdentifier() + " : " + businessException.getMessage();
        }
        if (ex.getTargetException() instanceof TrackAgoException) {
            TrackAgoException trackAgoException = (TrackAgoException) ex.getTargetException();
            messages = "DataNotFound " + trackAgoException.getType() + " : " + trackAgoException.getValue() + " --> " + trackAgoException.getMessage();
            notifySendableExceptions(ex, trackAgoException.getModuleIdentifier() + trackAgoException.getProcessIdentifier());
        }
        if (messages == null)
            messages = ex.getStackTrace().toString();

        TrackAgoResponse response = TrackAgoResponse.<String>builder()
                .body(null)
                .error()
                .addMessage(warnings.isEmpty() ? messages : null)
                .addWarning(!warnings.isEmpty() ? warnings : null)
                .buildInstance();

        String responseStr = objectMapperInstance().writeValueAsString(response);

        return response;

    }

    public TrackAgoResponse<String> handleRemoteExceptions(RemoteException ex) throws JsonProcessingException {

        TrackAgoResponse response = TrackAgoResponse.<String>builder()
                .body(null)
                .unreachableExternalServer()
                .addMessage("Dış Servise erişimde hata oluştu : " + ex.getMessage())
                .buildInstance();
        String responseStr = objectMapperInstance().writeValueAsString(response);
        notifySendableExceptions(ex, responseStr);
        return response;
    }


    public TrackAgoResponse<String> handleJsonProcessingException(JsonProcessingException ex) {

        TrackAgoResponse response = TrackAgoResponse.<String>builder()
                .body(null)
                .error()
                .addMessage("Json Process sırasında bir hata oluştu : " + ex.getMessage())
                .buildInstance();
        String responseStr = null;
        try {
            responseStr = objectMapperInstance().writeValueAsString(response);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        notifySendableExceptions(ex, responseStr);
        return response;

    }


    public TrackAgoResponse<String> handleOtherExceptions(Exception ex) throws JsonProcessingException {

        TrackAgoResponse response = TrackAgoResponse.<String>builder()
                .body(null)
                .error()
                .addMessage("Serviste Bir Sorun Oluştu : " + ex.getMessage())
                .buildInstance();
        String responseStr = objectMapperInstance().writeValueAsString(response);
        notifySendableExceptions(ex, responseStr);
        return response;

    }


    public void notifySendableExceptions(Exception ex, String responseStr) {
        if (ex.getClass().getName().contains("BadCredentialsException") || ex.getClass().getName().contains("AccessDeniedException"))
            return;

        if (ex.getClass().getName().contains("AxisFault") && ex.getMessage().contains("Read timed out"))
            return;

        if (ex.getMessage().contains("Bir hata ile karşılaşıldı."))
            return;

        sendNotification(" HATA" + ex.getClass().getName(), responseStr, "\n \n" + ExceptionUtils.getStackTrace(ex));
    }

    public abstract void sendNotification(String exceptionTitle, String responseStr, String exceptionStackTrace);

}
