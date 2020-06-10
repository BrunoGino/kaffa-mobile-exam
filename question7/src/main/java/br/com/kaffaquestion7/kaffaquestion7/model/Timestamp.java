package br.com.kaffaquestion7.kaffaquestion7.model;

import lombok.Value;

import java.time.LocalDateTime;

@Value
public class Timestamp {
    private LocalDateTime currentDateTime;

    public Timestamp() {
        this.currentDateTime = LocalDateTime.now();
    }
}
