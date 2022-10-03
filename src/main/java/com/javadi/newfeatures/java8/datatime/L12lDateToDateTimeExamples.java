package com.javadi.newfeatures.java8.datatime;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class L12lDateToDateTimeExamples {

    public static void main(String[] args) {

        // java.util.Date to LocalDateTime
        Date date = new Date();
        LocalDateTime localDateTime = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();

        // java.sql.Date to LocalDate
        LocalDate localDate = new java.sql.Date(System.currentTimeMillis()).toLocalDate();


    }

}
