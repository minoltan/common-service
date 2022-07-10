package com.amitech.springcommonservice.demos.java.designPatterns.creational.factory;

import org.springframework.web.multipart.MultipartFile;

public interface Chat {
    void sendMessage(String chatName,String message) throws Exception;
    void sendPhoto(String chatName, String caption, String imageUrl) throws Exception;
    void sendPhotoFile(String chatName, String caption, MultipartFile photo) throws Exception;
}
