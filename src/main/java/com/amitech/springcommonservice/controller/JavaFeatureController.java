package com.amitech.springcommonservice.controller;

import com.amitech.springcommonservice.service.JavaFeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/garbage/finalize")
    public void garbageCollectionFinalizeTest(){
        javaFeatureService.garbageCollectionFinalize();
    }

    @PostMapping("/garbage/cleaner")
    public void garbageCollectionCleanerTest(){
        javaFeatureService.garbageCollectionCleanerTest();
    }

    @PostMapping("/without/garbageCollection")
    public void withoutGarbageCollectionTest(){
        javaFeatureService.withoutGarbageCollection();
    }

    @PostMapping("/with/garbageCollection")
    public void withGarbageCollectionTest(){
        javaFeatureService.withGarbageCollection();
    }

    @PostMapping("/palindrome/manchers")
    public void findLongestPalindromicStringByManchersTest(@RequestParam String text){
        javaFeatureService.findLongestPalindromicStringByManchers(text);
    }

    @PostMapping("/palindrome")
    public void findLongestPalindromicStringTest(@RequestParam String text){
        javaFeatureService.longestPalSubstr(text);
    }
}
