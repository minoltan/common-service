package com.amitech.springcommonservice.service;

import com.amitech.springcommonservice.demos.springboot.transactional.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.UUID;

@Service
public class SpringbootFeatureService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    // If any failure occurs it will not save any table, we can mention what failure to what to do
    @Transactional()
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest flightBookingRequest){

        PassengerInfo passengerInfo = flightBookingRequest.getPassengerInfo();
        passengerInfoRepository.save(passengerInfo);
        PaymentInfo paymentInfo = flightBookingRequest.getPaymentInfo();
        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNumber(), paymentInfo.getFare());
        paymentInfo.setPassengerId(passengerInfo.getId());
        paymentInfo.setFare(passengerInfo.getAmount());

        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getAmount(), UUID.randomUUID().toString().split("-")[0], passengerInfo);
    }
}
