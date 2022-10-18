package com.javadi.newfeatures.java10.var;

import java.util.List;

public class NonDenotableTypes {

    public static void main(String[] args) {

        // we cannot use var while initializing a variable as null
        // var empty = null;




        // compiler sees this as a special type that has extended Object: NonDenotableTypes$1 extends Object
        var obj = new Object() {};
        System.out.println(obj.getClass()); // com.javadi.newfeatures.java10.var.NonDenotableTypes$1
        // we cannot assign it to an Object anymore
        // obj = new Object();

        var object = new Object();
        System.out.println(object.getClass()); // java.lang.Object


        // List<? extends Serializable & Comparable<? extends Serializable & Comparable<...>>>
        var list = List.of(1.2, 1, "3");
        // we cannot type above type in the  left-hand side
        // ??? element = list.get(0);

    }

}
