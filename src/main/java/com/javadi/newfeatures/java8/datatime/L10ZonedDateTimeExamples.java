package com.javadi.newfeatures.java8.datatime;


import java.time.ZoneId;
import java.time.ZonedDateTime;

public class L10ZonedDateTimeExamples {

    public static void main(String[] args) {

        // get all the available ZoneIds
        ZoneId.getAvailableZoneIds().forEach(System.out::println);

        // DateTime in another Zone:
        ZonedDateTime nowInLondon = ZonedDateTime.now(ZoneId.of("Europe/London"));
        System.out.println(nowInLondon); // 2022-10-03T13:27:46.139414400+01:00[Europe/London]



    }

}
