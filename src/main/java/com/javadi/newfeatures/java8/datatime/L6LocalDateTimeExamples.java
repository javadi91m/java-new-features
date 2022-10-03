package com.javadi.newfeatures.java8.datatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;

public class L6LocalDateTimeExamples {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime); // 2022-10-03T12:39:32.788708600

        localDateTime = LocalDateTime.of(2022, 10, 3, 12, 39, 32, 788);
        System.out.println("localDateTime = " + localDateTime); // 2022-10-03T12:39:32.000000788

        localDateTime = LocalDateTime.of(LocalDate.now(), LocalTime.now());
        System.out.println("localDateTime = " + localDateTime);


        // Get methods
        System.out.println("localDateTime.getHour() = " + localDateTime.getHour()); // 13
        System.out.println("localDateTime.get(ChronoField.MINUTE_OF_DAY) = " + localDateTime.get(ChronoField.MINUTE_OF_DAY)); // 828

        
        // Modify
        System.out.println("localDateTime.plusDays(1) = " + localDateTime.plusDays(1)); // 2022-10-04T13:51:19.493616
        System.out.println("localDateTime.plus(2, ChronoUnit.CENTURIES) = " + localDateTime.plus(2, ChronoUnit.CENTURIES)); // 2222-10-03T13:51:19.493616
        System.out.println("localDateTime.with(TemporalAdjusters.firstDayOfYear()) = " + localDateTime.with(TemporalAdjusters.firstDayOfYear())); // 2022-01-01T13:51:19.493616
        System.out.println("localDateTime.with(ChronoField.YEAR, 2023) = " + localDateTime.with(ChronoField.YEAR, 2023)); // 2023-10-03T13:51:19.493616
        System.out.println("localDateTime.with(LocalTime.MIDNIGHT) = " + localDateTime.with(LocalTime.MIDNIGHT)); // 2022-10-03T00:00

    }

}
