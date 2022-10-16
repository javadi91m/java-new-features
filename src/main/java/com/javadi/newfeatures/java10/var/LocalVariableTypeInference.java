package com.javadi.newfeatures.java10.var;

import com.javadi.newfeatures.java9.improvements.Book;

import java.util.ArrayList;
import java.util.List;

public class LocalVariableTypeInference {

    public static void main(String[] args) {

        // before Java 10
        String name = "Java";

        // Java 10
        var newName = "Java";

        // don't do this!
        var result = calculate();

        // var is a reserved type name, not a keyword
        var var = "var";

        // doesn't work in combination with lambdas
        // var predicate = s -> s.length() > 3;
        // var predicate = (String s) -> s.length() > 3;


        // compiler infers the List type of 'Object': ArrayList<Object>
        var myList = new ArrayList<>();

        // only declaration of variable with var doesn't work, we need to initialize it as well
        // var variable;


        // copyOf method
        List<String> list = new ArrayList<>();
        List<String> copyOfTheList = List.copyOf(list);


        // using var in a Stream pipeline can decrease code readability, especially if you use a bad variable name:
        var a = Book.getBook().getAuthors().stream().findFirst().map(String::length).orElse(0);

        // instead we can chop long pipeline above into multiple smaller variables:
        var authors = Book.getBook().getAuthors();
        var firstAuthor = authors.stream().findFirst();
        var length = firstAuthor.map(String::length).orElse(0);

    }

    public static String calculate() {
        return "test";
    }


}
