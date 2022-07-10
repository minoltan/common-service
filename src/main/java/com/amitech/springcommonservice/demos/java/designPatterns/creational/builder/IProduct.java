package com.amitech.springcommonservice.demos.java.designPatterns.creational.builder;

public interface IProduct {
    void setProcessor();
    void setMemory();
    void setStorage();

    String showDetails();
}
