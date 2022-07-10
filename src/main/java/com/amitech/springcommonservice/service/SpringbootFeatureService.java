package com.amitech.springcommonservice.service;

import com.amitech.springcommonservice.demos.springboot.completableFuture.User;
import com.amitech.springcommonservice.demos.springboot.completableFuture.UserRepository;
import com.amitech.springcommonservice.demos.springboot.transactional.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;

@Service
public class SpringbootFeatureService {

    @Autowired
    private PassengerInfoRepository passengerInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Autowired
    private UserRepository userRepository;

    Object target;
    Logger logger = LoggerFactory.getLogger(SpringbootFeatureService.class);

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

    @Async
    public CompletableFuture<List<User>> saveUsers(MultipartFile file) throws Exception {
        long start = System.currentTimeMillis();
        List<User> users = parseCSVFile(file);
        logger.info("saving list of users of size {}", users.size(), ""+Thread.currentThread().getName());
        users = userRepository.saveAll(users);
        long end  = System.currentTimeMillis();
        logger.info("Total time {}", (end-start));
        return CompletableFuture.completedFuture(users);

    }

    @Async
    public CompletableFuture<List<User>> findAllUsers(){
        logger.info("get list of user by "+Thread.currentThread().getName());
        List<User> users=userRepository.findAll();
        return CompletableFuture.completedFuture(users);
    }



    private List<User> parseCSVFile(final MultipartFile file) throws Exception {
        final List<User> users = new ArrayList<>();
        try {
            try (final BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()))) {
                String line;
                while ((line = br.readLine()) != null) {
                    final String[] data = line.split(",");
                    final User user = new User();
                    user.setName(data[0]);
                    user.setEmail(data[1]);
                    user.setGender(data[2]);
                    users.add(user);
                }
                return users;
            }
        } catch (final IOException e) {
            logger.error("Failed to parse CSV file {}", e);
            throw new Exception("Failed to parse CSV file {}", e);
        }
    }

}
