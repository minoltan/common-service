package com.amitech.springcommonservice.service;

import com.amitech.springcommonservice.client.TelegramClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class TelegramService {
    @Autowired
    TelegramClient telegramClient;


    public void sendPhotoToTelegramGroup(String caption, String photo) throws Exception {
        List<String> chatIdList = new ArrayList<>();
        chatIdList.add("@ImiLeaderboard");
        for(String chatId: chatIdList){
            telegramClient.sendPhoto(chatId,caption, photo);
        }
    }
    public void sendPhotoFileToTelegramGroup(String caption, MultipartFile photo) throws Exception {
        List<String> chatIdList = new ArrayList<>();
        chatIdList.add("@ImiLeaderboard");
        for(String chatId: chatIdList){
            telegramClient.sendPhotoFile(chatId,caption, photo);
        }

    }

    public void sendMessageToTelegramGroup(String message) throws Exception {
        List<String> chatIdList = new ArrayList<>();
        chatIdList.add("@ImiLeaderboard");
        for(String chatId: chatIdList){
            telegramClient.sendMessage(message, chatId);
        }

    }
}
