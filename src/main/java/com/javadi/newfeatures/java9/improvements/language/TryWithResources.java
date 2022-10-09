package com.javadi.newfeatures.java9.improvements.language;

import java.io.FileInputStream;
import java.io.IOException;

public class TryWithResources {

    public void normalTryWithResources() throws IOException {
        try (FileInputStream fis = new FileInputStream("~/tmp/test")) {
           fis.read();
        }
    }

    public void doWithFile(FileInputStream fis) throws IOException {

        try (FileInputStream fis2 = fis) {
            fis2.read();
        }

        // Only if fis is 'effectively final', can this form be used
        try (fis) {
            fis.read();
        }

    }
}
