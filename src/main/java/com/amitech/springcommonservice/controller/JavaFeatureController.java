package com.amitech.springcommonservice.controller;

import com.amitech.springcommonservice.service.JavaFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/java")
public class JavaFeatureController {

    @Autowired
    JavaFeatureService javaFeatureService;

    @GetMapping("/lambda")
    public List<Integer> lambdaCalculationTest(@RequestParam int num1, @RequestParam int num2){
       return javaFeatureService.getLambdaOutput(num1, num2);
    }
}
