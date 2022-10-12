package com.javadi.newfeatures.java9.stackwalker;

import java.lang.StackWalker.StackFrame;
import java.util.List;
import java.util.stream.Collectors;

public class StackWalkerDemo {

    public static void main(String... args) {

        // before Java 9, we had to go through this circus
        StackTraceElement[] stackTraceByThrowable = new Throwable().getStackTrace();
        StackTraceElement[] stackTraceFromThread = Thread.currentThread().getStackTrace();


        method1();
    }

    public static void method1() {
        method2();
    }

    public static void method2() {
        method3();
    }

    public static void method3() {
        method4();
    }

    public static void method4() {
        StackWalker stackWalker = StackWalker.getInstance();

        // forEach method
        stackWalker.forEach(stackFrame -> System.out.println(stackFrame));

        // walk method
        List<Integer> lines = stackWalker.walk(stackStream -> stackStream
                .filter(stackFrame -> stackFrame.getMethodName().startsWith("m"))
                .map(StackFrame::getLineNumber)
                .collect(Collectors.toList())
        );
        lines.forEach(System.out::println);

        stackWalker.walk(stackStream -> stackStream)
                .filter(stackFrame -> stackFrame.getMethodName().startsWith("m"))
                .map(StackFrame::getLineNumber)
                .collect(Collectors.toList());

    }

}
