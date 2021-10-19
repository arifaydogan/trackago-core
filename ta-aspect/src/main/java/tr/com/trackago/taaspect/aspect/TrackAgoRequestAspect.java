package tr.com.trackago.taaspect.aspect;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tr.com.trackago.taaspect.data.RequestContext;
import tr.com.trackago.taaspect.data.TrackAgoLogData;
import tr.com.trackago.tadto.TrackAgoBaseRequest;
import tr.com.trackago.tadto.TrackAgoResponse;
import tr.com.trackago.talogging.TrackAgoLogger;
import tr.com.trackago.talogging.TrackAgoLoggerFactory;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * {@link tr.com.trackago.taaspect.annotations.TrackAgoRequestMapping} annotation'ina sahip olan fonksiyonlar cagirildiginda Request
 * yonetim islemleri buradan yapilmaktadir.
 *
 * @author arifaydogan
 */

@Aspect
@Service
public class TrackAgoRequestAspect {


    TrackAgoLogger LOGGER = TrackAgoLoggerFactory.getLogger(TrackAgoRequestAspect.class);

    @Autowired
    RequestContext requestContext;

    /**
     * {@link tr.com.trackago.taaspect.annotations.TrackAgoRequestMapping} annotation'ina sahip olan fonksiyonlar cagirildiginda Request
     * baslatilir.
     *
     * @param joinPoint Join Point
     */
    @Around("@annotation(tr.com.trackago.taaspect.annotations.TrackAgoRequestMapping)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        TrackAgoLogData logData = getLogData(joinPoint);
        LOGGER.info(logData.toString());
        return logData.getProceed();
    }


    public TrackAgoLogData getLogData(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();
        ObjectMapper obj = new ObjectMapper();
        //  String strJsonRequest = "";
        //  String strJsonResponse = "";


        TrackAgoLogData logData = TrackAgoLogData.builder().build();

        if ((joinPoint.getArgs() != null && joinPoint.getArgs().length != 0) && joinPoint.getArgs()[0] instanceof TrackAgoBaseRequest) {
            String strJsonRequest = obj.writeValueAsString(joinPoint.getArgs()[0]);
            logData.setService(joinPoint.getSignature().getName());
            logData.setRequest(strJsonRequest);
            logData.setTime(new Date());
            logData.setUsername("System");

            HttpServletRequest webRequest = (HttpServletRequest) joinPoint.getArgs()[1];
            webRequest.setAttribute("trackAgoLogData", logData);

        }
//        Object proceed = null;
//        TrackAgoResponse exp = null;
//        String exceptionMessage = null;

        //try {
        Object proceed = joinPoint.proceed();
        //} catch (Exception e) {
//            exceptionMessage = "HATA : " + e.getMessage();
//            exp = TrackAgoResponse.builder()
//                    .body(exceptionMessage)
//                    .unreachableExternalServer()
//                    .buildInstance();
//        }

        long executionTime = System.currentTimeMillis() - start;
        if (proceed instanceof TrackAgoResponse) {
            ((TrackAgoResponse) proceed).setResponseDuration(executionTime);
            logData.setResponse(obj.writeValueAsString(proceed));
        }
//        else if (exp != null) {
//            exp.setResponseDuration(executionTime);
//            strJsonResponse = obj.writeValueAsString(exp);
//        }
        logData.setProceed(proceed);

        return logData;
    }

}
