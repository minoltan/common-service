package com.amitech.springcommonservice.demos.java.designPatterns.creational.builder.desktop;

import com.amitech.springcommonservice.demos.java.designPatterns.creational.builder.IProduct;

public class Desktop implements IProduct {

    private String test = "Desktop";
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
        System.out.println("Desktop");
        return test;
    }
}
