package com.javadi.newfeatures.java9.improvements.datetime;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class DurationMethods {

    public static void main(String[] args) {

        // dividedBy
        Duration tenDays = Duration.of(10, ChronoUnit.DAYS);
        Duration threeHours = Duration.of(3, ChronoUnit.HOURS);
        System.out.println(tenDays.dividedBy(threeHours)); // 80

        // truncatedTo
        Duration duration = Duration.ofDays(1).plusHours(1).plusMinutes(1)
                .plusSeconds(1).plusMillis(1);
        System.out.println(duration); // PT25H1M1.001S
        System.out.println(duration.truncatedTo(ChronoUnit.HOURS)); // PT25H


    }

}
