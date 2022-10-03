package com.javadi.newfeatures.java8.datatime;

import java.time.LocalTime;
import java.time.temporal.ChronoField;

public class L4LocalTimeExamples {

    public static void main(String[] args) {

        LocalTime localTime = LocalTime.now();
        System.out.println("localTime = " + localTime); // 10:45:03.442221400

        localTime = LocalTime.of(23, 1);
        System.out.println("localTime = " + localTime); // 23:01

        localTime = LocalTime.of(23, 1, 0, 999);
        System.out.println("localTime = " + localTime); // 23:01:00.000000999

        // Get methods
        System.out.println("localTime.getHour() = " + localTime.getHour());
        System.out.println("localTime.get(ChronoField.HOUR_OF_DAY) = " + localTime.get(ChronoField.HOUR_OF_DAY));

    }

}
