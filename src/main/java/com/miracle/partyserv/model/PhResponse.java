package com.miracle.partyserv.model;

import java.time.LocalDateTime;
import java.util.Objects;

public class PhResponse {
    private String message;
    private final LocalDateTime time;
    private String controlCode;

    public PhResponse(String controlCode, String message) {
        this.controlCode = controlCode;
        this.message = message;
        time = LocalDateTime.now();
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getControlCode() {
        return controlCode;
    }

    public void setControlCode(String controlCode) {
        this.controlCode = controlCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhResponse that = (PhResponse) o;
        return Objects.equals(message, that.message) && Objects.equals(time, that.time);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message, time);
    }
}
