package com.javadi.newfeatures.java8.datatime;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;

public class L1DateAndTimeExamples {

    public static void main(String[] args) {

        // Date
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        System.out.println("dateFormat = " + dateFormat.format(date)); // 2022-10-03

        DateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println("timeFormat = " + timeFormat.format(date)); // 10:13:40

        System.out.println(Calendar.getInstance().getTime()); // Mon Oct 03 10:16:20 IRST 2022

        // LocalDate
        LocalDate localDate = LocalDate.now();
        System.out.println("localDate = " + localDate); // 2022-10-03

        // LocalTime
        LocalTime localTime = LocalTime.now();
        System.out.println("localTime = " + localTime); // 10:16:20.128418900

        // LocalDateTime
        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println("localDateTime = " + localDateTime); // 2022-10-03T10:17:10.499377700

    }

}
