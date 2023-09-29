package com.example.practicespringport.controller.utils;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.Instant;

public class DateUtils {
    public static long calculateDateDifference(Timestamp startDate, Timestamp endDate) {
        Instant startInstant = startDate.toInstant();
        Instant endInstant = endDate.toInstant();
        Duration duration = Duration.between(startInstant, endInstant);
        return duration.toDays();
    }
}