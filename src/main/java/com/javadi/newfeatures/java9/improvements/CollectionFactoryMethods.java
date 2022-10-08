package com.javadi.newfeatures.java9.improvements;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionFactoryMethods {

    public static void main(String[] args) {

        // it's verbose
        // it won't work as field initializer (Fields are initialized immediately before the constructor for the object instance is called)
        List<String> books = new ArrayList<>();
        books.add("Java 9 Modularity");
        books.add("Designing Data-Intensive Applications");
        books.add("Java 8 Lambdas");

        // why we need to use Arrays?!
        // Lists only, no Set construction
        List<String> booksArrays = Arrays.asList("Java 9 Modularity", "Designing Data-Intensive Applications");

        // creates an anonymous class. for God's sake, please don't use this pattern!
        List<String> booksAnonymousClass = new ArrayList<>() {{
            add("Java 9 Modularity");
        }};

        // only for empty collections
        List<String> booksEmptyList = Collections.emptyList();
        Set<String> booksEmptySet = Collections.emptySet();
        Map<String, Object> booksEmptyMap = Collections.emptyMap();


        List<Integer> integerList = List.of(1, 2, 3);
        Set<Integer> integerSet = Set.of(1, 2, 3);
        Map<String, Integer> integerMap = Map.of(
                "1", 1,
                "2", 2,
                "3", 3
        );

        ////////////////////////////////////////////////

        // class java.util.ImmutableCollections$ListN
        System.out.println(integerList.getClass());

        // class java.util.ImmutableCollections$SetN
        System.out.println(integerSet.getClass());

        // class java.util.ImmutableCollections$MapN
        System.out.println(integerMap.getClass());

        ////////////////////////////////////////////////

        // Java 9
        System.out.println(List.of().getClass()); // class java.util.ImmutableCollections$List0
        System.out.println(List.of(1).getClass()); // class java.util.ImmutableCollections$List1
        System.out.println(List.of(1, 2).getClass()); // class java.util.ImmutableCollections$List2
        System.out.println(List.of(1, 2, 3).getClass()); // class java.util.ImmutableCollections$ListN

        // NEWER VERSIONS OF JAVA:
        System.out.println(List.of().getClass()); // class java.util.ImmutableCollections$List12
        System.out.println(List.of(1).getClass()); // class java.util.ImmutableCollections$List12
        System.out.println(List.of(1, 2).getClass()); // class java.util.ImmutableCollections$ListN
        System.out.println(List.of(1, 2, 3).getClass()); // class java.util.ImmutableCollections$ListN


        Map<String, String> map = Map.ofEntries(Map.entry("key1", "value1"), Map.entry("key2", "value2"));

    }

}
