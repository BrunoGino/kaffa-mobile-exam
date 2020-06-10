package br.com.kaffaquestion7.kaffaquestion7.controller.dto;

import br.com.kaffaquestion7.kaffaquestion7.model.Timestamp;
import lombok.Value;

import java.time.format.DateTimeFormatter;

@Value
public class TimestampDTO {
    private String currentDateTime;

    public TimestampDTO(Timestamp timestamp) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'");
        this.currentDateTime = dateTimeFormatter.format(timestamp.getCurrentDateTime());
    }

    public static TimestampDTO convertOne(Timestamp timestamp) {
        return new TimestampDTO(timestamp);
    }

}
