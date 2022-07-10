package com.amitech.springcommonservice.demos.java.designPatterns.creational.builder.laptop;

import com.amitech.springcommonservice.demos.java.designPatterns.creational.builder.IProduct;

public class Laptop implements IProduct {
    private String test = "Laptop";

    @Override
    public void setProcessor() {

    }

    @Override
    public void setMemory() {

    }

    @Override
    public void setStorage() {

    }

    @Override
    public String showDetails() {
        System.out.println("Laptop");
        return test;
    }
}
