package com.javadi.newfeatures.java8.datatime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class L13ConversionsAndFormatting {

    public static void main(String[] args) {

        // setting LocalDateTime to midnight
        LocalDateTime startOfDay1 = LocalDateTime.now().with(LocalTime.MIDNIGHT); // 2022-10-03T00:00
        LocalDateTime startOfDay2 = LocalDateTime.now().toLocalDate().atStartOfDay(); // 2022-10-03T00:00
        System.out.println(startOfDay1.equals(startOfDay2)); // true

        // parsing LocalDate
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parsedLocalDate = LocalDate.parse("2022-10-03", dateFormatter);

        // parsing LocalTime
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime parsedLocalTime = LocalTime.parse("15:31:02", timeFormatter);

        // parsing LocalDateTime
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
        LocalDateTime parsedLocalDateTime = LocalDateTime.parse("2022-10-03T15:31:02", dateTimeFormatter);

        // formatting a LocalDateTime
        String formatted = parsedLocalDateTime.format(dateFormatter); // 2022-10-03

        // Date and LocalDateTime conversions
        Date date = new Date();
        LocalDateTime fromDate = LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());

        LocalDateTime localDateTime = LocalDateTime.now();
        Date fromLocalDateTime = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());

        ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.systemDefault());
        Date fromZonedDateTime = Date.from(zonedDateTime.toInstant());

    }

}
