package com.javadi.newfeatures.java8.datatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class L7LocalDateToDateAndTimeExamples {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();

        LocalDate localDate = localDateTime.toLocalDate();
        LocalTime localTime = localDateTime.toLocalTime();

        LocalDateTime newLocalDateTime = LocalDateTime.of(localDate, localTime);
        System.out.println(newLocalDateTime.equals(localDateTime)); // true

    }

}
