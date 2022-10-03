package com.javadi.newfeatures.java8.datatime;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoField;
import java.time.temporal.TemporalAdjusters;

public class L3LocalDateModifyExamples {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now(); // 2022-10-03

        System.out.println("localDate.plusDays(4) = " + localDate.plusDays(4)); // 2022-10-07
        System.out.println("localDate = " + localDate); // 2022-10-03 => because LocalDate is immutable

        System.out.println("localDate.minusWeeks(3) = " + localDate.minusWeeks(3)); // 2022-09-12

        // changing the year
        System.out.println("localDate.withYear(2023) = " + localDate.withYear(2023)); // 2023-10-03

        // changing the year by using ChronoField
        System.out.println("localDate.with(ChronoField.YEAR, 2023) = " + localDate.with(ChronoField.YEAR, 2023));

        // adjusting date by using TemporalAdjusters
        System.out.println("localDate.with(TemporalAdjusters.previous(DayOfWeek.MONDAY)) = " + localDate.with(TemporalAdjusters.previous(DayOfWeek.MONDAY))); // 2022-09-26

    }

}
