package com.javadi.newfeatures.java9.process;

import java.lang.management.ManagementFactory;

public class ProcessId {

    public static void main(String... args) {

        // Before Java 9 :(
        long pidOld = Long.parseLong(ManagementFactory.getRuntimeMXBean().getName().split("@")[0]);

        // With the new ProcessHandle API in Java 9:
        long pidNew = ProcessHandle.current().pid();

        long parentPid = ProcessHandle.current().parent().get().pid();

        System.out.printf("{ pidOld: %s, pidNew: %s }\nparentPid (IDE): %s%n", pidOld, pidNew, parentPid);

        // java.lang.IllegalStateException
        ProcessHandle.current().destroyForcibly();

    }

}