package com.amitech.springcommonservice.demos.java.features.garbageCollection;

/**
 * @author Minoltan Issack on 7/22/2022
 */
public class Employee {

    private static int nextId = 1;
    private final int ID;
    private final String name;
    private final int age;
    // it is made static because it
    // is keep common among all and
    // shared by all objects

    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
        this.ID = nextId++;
    }

    public void show() {
        System.out.println("Id=" + ID + "\nName=" + name
                + "\nAge=" + age);
    }

    public void showNextId() {
        System.out.println("Next employee id will be="
                + nextId);
    }

}
