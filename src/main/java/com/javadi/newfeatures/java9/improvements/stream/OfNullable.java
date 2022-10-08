package com.javadi.newfeatures.java9.improvements.stream;

import com.javadi.newfeatures.java9.improvements.Book;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

public class OfNullable {

    public static void main(String... args) {

        long zero = Stream.ofNullable(null).count();
        long one = Stream.ofNullable(Book.getBook()).count();

        System.out.printf("zero: %d, one: %d\n", zero, one); // zero: 0, one: 1

        // Before ofNullable
        Book book = getPossiblyNull();
        Stream<String> authors = book == null ? Stream.empty() : book.authors.stream();
        authors.forEach(System.out::println);

        // With ofNullable
        Stream.ofNullable(getPossiblyNull())
                .flatMap(b -> b.authors.stream())
                .forEach(System.out::println);
    }

    private static Book getPossiblyNull() {
        return ThreadLocalRandom.current().nextBoolean() ? null : Book.getBook();
    }


}
