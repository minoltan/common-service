package com.amitech.springcommonservice.controller;


import com.amitech.springcommonservice.demos.springboot.completableFuture.User;
import com.amitech.springcommonservice.demos.springboot.transactional.FlightBookingAcknowledgement;
import com.amitech.springcommonservice.demos.springboot.transactional.FlightBookingRequest;
import com.amitech.springcommonservice.service.SpringbootFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/spring")
@EnableTransactionManagement
public class SpringbootFeatureController {

    @Autowired
    SpringbootFeatureService springbootFeatureService;

    // Transactional
    @PostMapping("/book/flight/ticket")
    public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest flightBookingRequest){
           return springbootFeatureService.bookFlightTicket(flightBookingRequest);
    }

    // Multi threading Completable Future
    @PostMapping(value = "/users", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE}, produces = "application/json")
    public ResponseEntity saveUsers(@RequestParam(value = "files") MultipartFile[] files) throws Exception {
        for (MultipartFile file : files) {
            springbootFeatureService.saveUsers(file);
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Multi threading Completable Future
    @GetMapping(value = "/users", produces = "application/json")
    public CompletableFuture<ResponseEntity> findAllUsers() {
        return  springbootFeatureService.findAllUsers().thenApply(ResponseEntity::ok);
    }

    // Multi threading Completable Future
    @GetMapping(value = "/getUsersByThread", produces = "application/json")
    public  ResponseEntity getUsers(){
        CompletableFuture<List<User>> users1=springbootFeatureService.findAllUsers();
        CompletableFuture<List<User>> users2=springbootFeatureService.findAllUsers();
        CompletableFuture<List<User>> users3=springbootFeatureService.findAllUsers();
        CompletableFuture.allOf(users1,users2,users3).join();
        return  ResponseEntity.status(HttpStatus.OK).build();
    }
}
