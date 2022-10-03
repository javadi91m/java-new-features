package com.javadi.newfeatures.java8.datatime;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class L9InstantExamples {

    public static void main(String[] args) {

        Instant instant = Instant.now();
        System.out.println(instant); // 2022-10-03T12:16:32.272322400Z

        Instant instantByMillis = Instant.ofEpochMilli(System.currentTimeMillis());
        System.out.println(instantByMillis); // 2022-10-03T12:16:32.272Z

        System.out.println(instant.getNano()); // 566655400 == the nanoseconds within the second

        System.out.println(Duration.between(instant.plusSeconds(10), instant).toSeconds()); // -10


        // creating LocalDateTime from Instant
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());

    }

}
