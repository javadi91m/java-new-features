package com.javadi.newfeatures.java9.security;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputFilter;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FilterIncomingSerializationData {

    public static void main(String[] args) throws Exception {

        //Serialization
        String developerFilename = "./developer.ser";
        serialize(developerFilename, new Developer("John Doe", "Java Developer"));

        String managerFilename = "./manager.ser";
        serialize(managerFilename, new Manager("John Doe", "Engineering Manager"));


        DeveloperClassFilter developerClassFilter = new DeveloperClassFilter();

        //Deserialization
        try (FileInputStream fis = new FileInputStream(developerFilename);
             ObjectInputStream objectInputStream = new ObjectInputStream(fis)) {
            // setting ObjectInputFilter per stream
            objectInputStream.setObjectInputFilter(developerClassFilter);

            Developer employee = (Developer) objectInputStream.readObject();
            System.out.println(employee.getName());
            System.out.println(employee.getTitle());
        }


        ObjectInputFilter.Config.setSerialFilter(developerClassFilter);
        // setting ObjectInputFilter for all streams
        try (FileInputStream fis = new FileInputStream(managerFilename);
             ObjectInputStream objectInputStream = new ObjectInputStream(fis)) {
            Manager manager = (Manager) objectInputStream.readObject();
            System.out.println(manager.getName());
            System.out.println(manager.getTitle());
        } catch (java.io.InvalidClassException e) {
            e.printStackTrace();
        }

    }

    private static void serialize(String filename, Employee employee) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(employee);
        oos.close();
        fos.close();
    }

}
