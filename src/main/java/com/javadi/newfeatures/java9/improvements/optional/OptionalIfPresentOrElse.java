package com.javadi.newfeatures.java9.improvements.optional;

import com.javadi.newfeatures.java9.improvements.Book;

import java.util.Optional;
import java.util.concurrent.ThreadLocalRandom;

public class OptionalIfPresentOrElse {

    public static void main(String... args) {

        Optional<Book> optional = getOptionalBook();

        // Before ifPresentOrElse
        optional.ifPresent(System.out::println);
        if (optional.isPresent()) {
            System.out.println(optional.get());
        } else {
            System.out.println("Nothing here");
        }

        optional.ifPresentOrElse(
                book -> System.out.println(book),
                () -> System.out.println("Nothing here!")
        );

    }

    private static Optional<Book> getOptionalBook() {
        return ThreadLocalRandom.current().nextBoolean() ? Optional.of(Book.getBook()) : Optional.empty();
    }

}
