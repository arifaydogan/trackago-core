package tr.com.trackago.taaspect.data;

import lombok.*;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class TrackAgoLogData {

    private Object proceed;
    private String service;
    private String request;
    private String response;
    private Date time;
    private String username;
    private boolean exception;
    private String exceptionMessage;

}
