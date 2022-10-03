package com.javadi.newfeatures.java8.datatime;


import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class L11LocalDateTimeToZonedDateTimeExamples {

    public static void main(String[] args) {

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime); // 2022-10-03T16:01:21.629333700

        // NOTICE: the time does not change while setting a new Zone,
        // the only change is that the new Zone will be attached to the LocalDateTime
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.of("Europe/London"));
        System.out.println(zonedDateTime); // 2022-10-03T16:01:21.629333700+01:00[Europe/London]

        // setting an offset
        OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.ofHoursMinutes(-2, -30));
        System.out.println(offsetDateTime); // 2022-10-03T16:01:21.629333700-02:30


    }

}
