package com.amitech.springcommonservice.controller;


import com.amitech.springcommonservice.demos.springboot.transactional.FlightBookingAcknowledgement;
import com.amitech.springcommonservice.demos.springboot.transactional.FlightBookingRequest;
import com.amitech.springcommonservice.service.SpringbootFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/spring")
@EnableTransactionManagement
public class SpringbootFeatureController {

    @Autowired
    SpringbootFeatureService springbootFeatureService;

    @PostMapping("/book/flight/ticket")
    public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest flightBookingRequest){
           return springbootFeatureService.bookFlightTicket(flightBookingRequest);
    }
}
