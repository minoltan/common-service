package com.amitech.springcommonservice.demos.springboot.transactional;

public class InsufficientAmountException extends RuntimeException{
    public InsufficientAmountException(String msg){
        super(msg);
    }
}
