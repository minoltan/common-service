package com.amitech.springcommonservice.controller;

import com.amitech.springcommonservice.demos.java.designPatterns.creational.factory.MessageResource;
import com.amitech.springcommonservice.service.DesignPatternService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/design/pattern")
public class DesignPatternController {

    @Autowired
    DesignPatternService designPatternService;

    @GetMapping("/singleton")
    public List<String> createMsisdnList(){
       return designPatternService.createMsisdnList();
    }

    @GetMapping("/builder")
    public String builderPattern(){
        return designPatternService.builderPatternTest();
    }

    @PostMapping("/factory")
    public void sendSingleMessage(@RequestBody MessageResource messageResource) throws Exception {
        designPatternService.sendSingleMessage(messageResource);
    }



}
