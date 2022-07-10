package com.amitech.springcommonservice.demos.java.designPatterns.creational.builder;

public class Director {

    public IProduct createProduct(IBuilder builder, String param){
        builder.createObject();
        builder.initializeObject(param);
        return builder.returnObject();
    }
}
