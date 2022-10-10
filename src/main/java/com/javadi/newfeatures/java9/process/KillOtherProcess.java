package com.javadi.newfeatures.java9.process;

public class KillOtherProcess {

    public static void main(String... args) throws Exception {

        ProcessHandle notepadProcess = ProcessHandle.allProcesses()
                        .filter(processHandle -> processHandle.info()
                                .command()
                                .map(cmd -> cmd.contains("notepad++"))
                                .orElse(false))
                        .findFirst()
                        .orElseThrow(() -> new IllegalArgumentException("No matching handle found"));
        System.out.println(notepadProcess.info());

        notepadProcess.onExit()
                .thenAccept(h -> System.out.println("Notepad++ was killed by Java!"));

        boolean shutdown = notepadProcess.destroy();

        notepadProcess.onExit().join();
        System.out.println("Shutdown: " + shutdown);

    }

}
