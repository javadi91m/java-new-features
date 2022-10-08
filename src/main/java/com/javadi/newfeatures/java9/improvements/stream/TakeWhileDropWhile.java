package com.javadi.newfeatures.java9.improvements.stream;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class TakeWhileDropWhile {

    public static void main(String... args) throws Exception {

        // we can use this method to find a Git conflict!
        // Files.lines -> returns a Stream of lines
        Stream<String> streamOfLines = Files.lines(Paths.get("src/main/resources/index.html"));
        try (streamOfLines) {
            streamOfLines.dropWhile(line -> !line.contains("<<<<<<<"))
                    // because dropWhile will consist "<<<<<<<" line itself: dropWhile is inclusive
                    .skip(1)
                    // takeWhile is exclusive
                    .takeWhile(line -> !line.contains(">>>>>>>"))
                    .forEach(System.out::println);

        }


        // Before takeWhile
        IntStream.range(1, 100)
                .filter(i -> i < 4) // applied to all elements
                .forEach(System.out::println);

        // With takeWhile, only the first 4 elements are // evaluated against the predicate.
        IntStream.range(1, 100)
                .takeWhile(i -> i < 4) // short-circuits on element '4'
                .forEach(System.out::println);


        // Before dropWhile
        IntStream.range(1, 10)
                .filter(i -> i >= 4)
                .forEach(System.out::println);

        // With dropWhile (only works if Stream is sorted!)
        IntStream.range(1, 10)
                .dropWhile(i -> i < 4)
                .forEach(System.out::println);

    }


}
