package com.javadi.newfeatures.java9.improvements.stream;

import com.javadi.newfeatures.java9.improvements.Book;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class NewCollectors {
    public static void main(String... args) {
        // a quick refresher of Collectors...
        List<Integer> ints = Stream.of(1, 2, 3)
                .map(n -> n + 1)
                .collect(Collectors.toList());
        System.out.println(ints); // [2, 3, 4]

        // a quick refresher of Collectors...
        Map<Integer, List<Integer>> groupedInts = Stream.of(1, 2, 3, 3)
                .collect(Collectors.groupingBy(
                        i -> i % 2,
                        Collectors.toList())
                );
        System.out.println(groupedInts); // {0=[2], 1=[1, 3, 3]}

        // // a quick refresher of Collectors: calculating average prices of each author
        Map<Set<String>, Double> averagePricesOfAuthors = Book.getBooks().collect(Collectors.groupingBy(
                        book -> book.getAuthors(),
                        Collectors.averagingDouble(book -> book.getPrice())
                )
        );
        System.out.println("averagePricesOfAuthors = " + averagePricesOfAuthors);


        // New APIs

        // Collect all books costing more than 10, grouped by author(s)
        Map<Set<String>, Set<Book>> booksByAuthors = Book.getBooks()
                .collect(Collectors.groupingBy(
                                book -> book.getAuthors(),
                                Collectors.filtering(
                                        b -> b.getPrice() > 10,
                                        Collectors.toSet())
                        )
                );
        System.out.println(booksByAuthors);

        Map<Integer, Long> count = Stream.of(1, 2, 3).collect(
                Collectors.flatMapping(
                        i -> Stream.of(i, i + 1),
                        Collectors.groupingBy(i -> i, Collectors.counting()))
        );
        System.out.println("count = " + count); // {1=1, 2=2, 3=2, 4=1}


        // Collect all authors that sell books at a given price
        Map<Double, Set<String>> authorsSellingForPrice = Book.getBooks()
                .collect(Collectors.groupingBy(
                                Book::getPrice,
                                Collectors.flatMapping(
                                        b -> b.getAuthors().stream(),
                                        Collectors.toSet())
                        )
                );
        System.out.println(authorsSellingForPrice); // {33.99=[Richard Warburton, Sander Mak, Paul Bakker], 38.99=[Martin Klepmann]}
    }
}
