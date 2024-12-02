package org.example.javacore;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

public class MyLocalDateTime {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy:MM:dd##HH:mm:ss:SSS", locale = "ru")
    private LocalDateTime localDateTime;

    public MyLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }
}
