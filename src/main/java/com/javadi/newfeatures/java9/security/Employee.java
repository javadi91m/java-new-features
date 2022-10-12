package com.javadi.newfeatures.java9.security;

import java.io.Serializable;

public abstract class Employee implements Serializable {

    private String name;
    private String title;

    public Employee() {
    }

    public Employee(String name, String title) {
        this.name = name;
        this.title = title;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

}
