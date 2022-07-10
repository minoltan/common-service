package com.amitech.springcommonservice.service;

import com.amitech.springcommonservice.demos.java.designPatterns.creational.builder.Director;
import com.amitech.springcommonservice.demos.java.designPatterns.creational.builder.IBuilder;
import com.amitech.springcommonservice.demos.java.designPatterns.creational.builder.IProduct;
import com.amitech.springcommonservice.demos.java.designPatterns.creational.builder.desktop.DesktopBuilder;
import com.amitech.springcommonservice.demos.java.designPatterns.creational.builder.laptop.LaptopBuilder;
import com.amitech.springcommonservice.demos.java.designPatterns.creational.factory.Chat;
import com.amitech.springcommonservice.demos.java.designPatterns.creational.factory.ChatFactory;
import com.amitech.springcommonservice.demos.java.designPatterns.creational.factory.MessageResource;
import com.amitech.springcommonservice.demos.java.designPatterns.creational.singleton.MsisdnList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DesignPatternService {

    @Autowired
    ChatFactory chatFactory;

    public String builderPatternTest(){
        Director objectBuilder = new Director();
        IBuilder builder = new LaptopBuilder();
        IProduct obj = objectBuilder.createProduct(builder, "param");
        obj.showDetails();

        builder = new DesktopBuilder();
        obj = objectBuilder.createProduct(builder,"param");
        obj.showDetails();

        return obj.showDetails();

    }

    public void sendSingleMessage(MessageResource messageResource) throws Exception {
        Chat chatPlatform = chatFactory.getChatPlatform(messageResource.getPlatform());
        chatPlatform.sendMessage(messageResource.getChatName(), messageResource.getMessage());
    }

    public List<String> createMsisdnList(){
        return MsisdnList.getInstance().getMsisdnList();
    }
}
