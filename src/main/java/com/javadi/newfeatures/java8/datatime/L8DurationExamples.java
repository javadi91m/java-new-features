package com.javadi.newfeatures.java8.datatime;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class L8DurationExamples {

    public static void main(String[] args) {

        // Duration between two LocalDateTime instances
        LocalDateTime start = LocalDateTime.now();
        LocalDateTime end = start.plusDays(2).plusHours(1);

        System.out.println(Duration.between(start, end).toHours()); // 49

        Duration duration = Duration.ofHours(2);
        System.out.println("duration.toMinutes() = " + duration.toMinutes()); // 120

        LocalDate d1 = LocalDate.now();
        LocalDate d2 = d1.plusDays(1);
        // Duration cannot be calculated from LocalDate
        System.out.println("Duration.between(d1, d2).toDays() = " + Duration.between(d1, d2).toDays()); // throws java.time.temporal.UnsupportedTemporalTypeException

        // Duration cannot be calculated from LocalTime
        LocalTime t1 = LocalTime.now();
        LocalTime t2 = t1.plusHours(2);
        System.out.println("Duration.between(t1, t2).toHours() = " + Duration.between(t1, t2).toHours()); // throws java.time.temporal.UnsupportedTemporalTypeException

    }

}
