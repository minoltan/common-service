package com.amitech.springcommonservice.demos.springboot.ModalParentChild;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Child extends Parent{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String chile;
    


}
