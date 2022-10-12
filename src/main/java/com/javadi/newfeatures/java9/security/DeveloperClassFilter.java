package com.javadi.newfeatures.java9.security;

import java.io.ObjectInputFilter;

public class DeveloperClassFilter implements ObjectInputFilter {

    public Status checkInput(FilterInfo filterInfo) {
        // is REJECTED is returned, an exception will be thrown: java.io.InvalidClassException: filter status: REJECTED
        Class<?> clazz = filterInfo.serialClass();
        if (clazz != null) {
            return clazz.getName().equals("com.javadi.newfeatures.java9.security.Developer")
                    || clazz.getName().equals("com.javadi.newfeatures.java9.security.Employee")
                    ? Status.ALLOWED : Status.REJECTED; //clazz.getPackage().equals("com.example")
        }
        return Status.UNDECIDED;
    }

}
