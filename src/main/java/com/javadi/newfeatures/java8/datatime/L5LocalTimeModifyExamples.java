package com.javadi.newfeatures.java8.datatime;

import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class L5LocalTimeModifyExamples {

    public static void main(String[] args) {

        LocalTime localTime = LocalTime.now(); // 12:36:11.495971400
        System.out.println("localTime.plusHours(1) = " + localTime.plusHours(1)); // 13:36:11.495971400
        System.out.println("localTime.minus(2 , ChronoUnit.MINUTES) = " + localTime.minus(2, ChronoUnit.MINUTES)); // 12:34:11.495971400

        System.out.println("localTime.with(LocalTime.MIDNIGHT) = " + localTime.with(LocalTime.MIDNIGHT)); // 00:00
        System.out.println("localTime.with(ChronoField.HOUR_OF_DAY, 4) = " + localTime.with(ChronoField.HOUR_OF_DAY, 4)); // 04:37:59.832091700

    }

}
