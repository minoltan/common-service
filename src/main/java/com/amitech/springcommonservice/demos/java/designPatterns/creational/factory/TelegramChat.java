package com.amitech.springcommonservice.demos.java.designPatterns.creational.factory;

import com.amitech.springcommonservice.client.TelegramClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class TelegramChat implements Chat {
    @Autowired
    TelegramClient telegramClient;

    @Override
    public void sendMessage(String chatName,String message) throws Exception {
       telegramClient.sendMessage(chatName,message);
    }

    @Override
    public void sendPhoto(String chatName, String caption, String imageUrl) throws Exception {
        telegramClient.sendPhoto(chatName,caption,imageUrl);
    }

    @Override
    public void sendPhotoFile(String chatName, String caption, MultipartFile photo) throws Exception {
        telegramClient.sendPhotoFile(chatName,caption,photo);
    }

}
