package com.amitech.springcommonservice.demos.java.designPatterns.creational.builder;

public interface IBuilder {
    void createObject();
    void initializeObject(String param);
    IProduct returnObject();
}
