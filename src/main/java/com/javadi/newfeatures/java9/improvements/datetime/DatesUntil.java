package com.javadi.newfeatures.java9.improvements.datetime;

import java.time.LocalDate;
import java.time.Period;
import java.time.Year;
import java.util.stream.Stream;

public class DatesUntil {

    public static void main(String... args) {
        LocalDate start = LocalDate.of(2017, 12, 1);
        Stream<LocalDate> dates = start.datesUntil(start.plusDays(7));
        dates.forEach(System.out::println);
        // 2017-12-01
        // 2017-12-02
        // 2017-12-03
        // 2017-12-04
        // 2017-12-05
        // 2017-12-06
        // 2017-12-07

        LocalDate birthday = LocalDate.of(1983, 12, 6);
        long leapYears = birthday
                .datesUntil(LocalDate.now(), Period.ofYears(1))
                .map(d -> Year.of(d.getYear()))
                .filter(Year::isLeap)
                .count();
        System.out.println(leapYears); // 10
    }
}
