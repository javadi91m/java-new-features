package com.javadi.newfeatures.java9.improvements.optional;

import com.javadi.newfeatures.java9.improvements.Book;

import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public class OptionalOr {
    public static void main(String... args) {

        Optional<Book> localFallback = Optional.of(Book.getBook());

        // Before Optional.or
        Book bestBookBefore = getBestOffer()
                .orElse(getExternalOffer().orElse(localFallback.get()));  // .get() is BAD!

        Optional<Book> bestBook = getBestOffer()
                .or(() -> getExternalOffer())
                .or(() -> localFallback);

        System.out.println(bestBook);

    }

    static Optional<Book> getBestOffer() {
        return Optional.empty();
    }

    static Optional<Book> getExternalOffer() {
        return ThreadLocalRandom.current().nextBoolean() ? Optional.of(new Book("External Book", Set.of(), 11.99)) : Optional.empty();
    }

}