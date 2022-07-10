package com.amitech.springcommonservice.controller;

import com.amitech.springcommonservice.service.TelegramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/telegram")
public class TelegramController {

    @Autowired
    TelegramService telegramService;

    @PostMapping("/sendPhoto")
    public void sendPhotoToTelegramGroup(String caption, String photo) throws Exception {
        telegramService.sendPhotoToTelegramGroup(caption, photo);
    }

    @PostMapping("/sendPhoto/file")
    public void sendPhotoFileToTelegramGroup(@RequestParam("caption") String caption, @RequestPart("photo") MultipartFile photo) throws Exception {
        telegramService.sendPhotoFileToTelegramGroup(caption, photo);
    }

    @PostMapping("/sendMessage")
    public void sendMessageToTelegramGroup(@RequestParam("message") String message) throws Exception {
        telegramService.sendMessageToTelegramGroup(message);
    }

    @PostMapping("/test")
    public String test(){
        System.out.println("Test API");
        return "api response";
    }

//    @PostMapping("/sendGame")

}
