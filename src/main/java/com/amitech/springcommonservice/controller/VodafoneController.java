package com.amitech.springcommonservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping
public class VodafoneController {

    @GetMapping("/home")
    public String index() {
        return "home/index";
    }

    @GetMapping("/checkout")
    public String checkoutIndex() {
        return "checkout/index";
    }
}
