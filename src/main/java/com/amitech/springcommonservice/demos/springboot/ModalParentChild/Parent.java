package com.amitech.springcommonservice.demos.springboot.ModalParentChild;

import lombok.*;

import javax.persistence.*;


@MappedSuperclass
public class Parent {

    private String name;
    private String email;
    private double amount;
}
