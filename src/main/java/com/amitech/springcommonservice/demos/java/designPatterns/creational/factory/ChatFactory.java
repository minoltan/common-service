package com.amitech.springcommonservice.demos.java.designPatterns.creational.factory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ChatFactory {

    @Autowired
    TelegramChat telegramChat;

    public Chat getChatPlatform(String platform){
        switch (platform){
            case "telegram":
                return telegramChat;
            default: return null;
        }

    }
}
