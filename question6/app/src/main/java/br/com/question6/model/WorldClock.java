package br.com.question6.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WorldClock {
    private String currentDateTime;
    private String dayOfTheWeek;
    private String timeZoneName;

    public LocalDateTime getCurrentDateTimeAsObject() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm'Z'");
        return LocalDateTime.parse(currentDateTime, dateTimeFormatter);
    }

    public String getCurrentDateTime() {
        return currentDateTime;
    }

    public String getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public void setCurrentDateTime(String currentDateTime) {
        this.currentDateTime = currentDateTime;
    }

    public void setDayOfTheWeek(String dayOfTheWeek) {
        this.dayOfTheWeek = dayOfTheWeek;
    }

    public String getTimeZoneName() {
        return timeZoneName;
    }

    public void setTimeZoneName(String timeZoneName) {
        this.timeZoneName = timeZoneName;
    }
}
