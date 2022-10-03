package com.javadi.newfeatures.java8.datatime;

import java.time.LocalDate;
import java.time.temporal.ChronoField;

public class L2LocalDateExamples {

    public static void main(String[] args) {

        // creating LocalDate
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate); // 2022-10-03

        // using day of the year
        int year = 2022;
        int dayOfYear = 365;
        localDate = LocalDate.ofYearDay(year, dayOfYear);
        System.out.println("localDate = " + localDate); // 2022-12-31

        // .of

        localDate = LocalDate.of(2022, 10, 3);
        System.out.println("localDate = " + localDate); // 2022-10-03


        // Get methods: 2022-10-03
        System.out.println("localDate.getMonth().name() = " + localDate.getMonth().name()); // OCTOBER
        System.out.println("localDate.getDayOfMonth() = " + localDate.getDayOfMonth()); // 3
        System.out.println("localDate.getDayOfYear() = " + localDate.getDayOfYear()); // 276
        System.out.println("localDate.getDayOfWeek().name() = " + localDate.getDayOfWeek().name()); // MONDAY
        // there are lots of constants in ChronoField (enum) which we can use:
        System.out.println(" localDate.get(ChronoField.DAY_OF_YEAR) = " + localDate.get(ChronoField.DAY_OF_YEAR)); // 276
        System.out.println(" localDate.get(ChronoField.YEAR_OF_ERA) = " + localDate.get(ChronoField.YEAR_OF_ERA)); // 2022

    }

}
