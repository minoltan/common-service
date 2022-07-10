package com.amitech.springcommonservice.demos.java.designPatterns.creational.builder.laptop;

import com.amitech.springcommonservice.demos.java.designPatterns.creational.builder.IBuilder;
import com.amitech.springcommonservice.demos.java.designPatterns.creational.builder.IProduct;

public class LaptopBuilder implements IBuilder {
    Laptop obj;
    @Override
    public void createObject() {
        obj = new Laptop();
    }

    @Override
    public void initializeObject(String param) {

    }

    @Override
    public IProduct returnObject() {
        return obj;
    }


}
