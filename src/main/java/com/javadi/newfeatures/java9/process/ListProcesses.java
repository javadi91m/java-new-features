package com.javadi.newfeatures.java9.process;

import java.time.Instant;
import java.util.Comparator;

public class ListProcesses {

    public static void main(String... args) {
        // ProcessHandle.allProcesses() returns a snapshot of running processes in the time it has been called
        // so it's always a stable view, but it might be a little out of date
        // because processes might start and end in any instant
        ProcessHandle.allProcesses()
                .map(ProcessHandle::info)
                // sort them based on their start time
                .sorted(Comparator.comparing(info -> info.startInstant().orElse(Instant.MAX)))
                .forEach(ListProcesses::printInfo);
    }

    private static void printInfo(ProcessHandle.Info info) {
        if (info.startInstant().isPresent() && info.command().isPresent()) {
            System.out.println("Started at: " + info.startInstant().get() + ", Command: " + info.command().get());
        }
    }

}
