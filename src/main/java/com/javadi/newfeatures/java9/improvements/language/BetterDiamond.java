package com.javadi.newfeatures.java9.improvements.language;

import java.util.ArrayList;

public class BetterDiamond {

    public static void main(String... args) {
        // Java 5
        ArrayList<String> list1 = new ArrayList<String>();

        // Java 7
        ArrayList<String> list2 = new ArrayList<>();

        // this code doesn't compile in Java 7,8: the compiler complains says it cannot infer type arguments for ArrayList
        // the reason is we cannot use a diamond operator with anonymous inner classes
        ArrayList<String> list3 = new ArrayList<>() {
            @Override
            public boolean add(String s) {
                System.out.println("Adding " + s);
                return super.add(s);
            }
        };

    }

}