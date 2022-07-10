package com.amitech.springcommonservice.demos.java.designPatterns.creational.builder.desktop;

import com.amitech.springcommonservice.demos.java.designPatterns.creational.builder.IProduct;
import com.amitech.springcommonservice.demos.java.designPatterns.creational.builder.IBuilder;

public class DesktopBuilder implements IBuilder {

    Desktop obj;
    @Override
    public void createObject() {
        obj = new Desktop();
    }

    @Override
    public void initializeObject(String param) {

    }

    @Override
    public IProduct returnObject() {
        return obj;
    }

}
