package com.amitech.springcommonservice.demos.java.features.garbageCollection;

/**
 * @author Minoltan Issack on 7/22/2022
 */

public class GarbageTest {
    private String name;

    public GarbageTest() {
    }

    public GarbageTest(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Test{" +
                "name='" + name + '\'' +
                '}';
    }
}
