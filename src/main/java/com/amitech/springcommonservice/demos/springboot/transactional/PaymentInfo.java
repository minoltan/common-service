package com.amitech.springcommonservice.demos.springboot.transactional;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PaymentInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("account_number")
    private String accountNumber;
    @JsonProperty("card_type")
    private String cardType;
    @JsonProperty("passenger_id")
    private Long passengerId;
    private double fare;

}
