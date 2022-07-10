package com.amitech.springcommonservice.controller;

import com.amitech.springcommonservice.resource.TokenResource;
import com.amitech.springcommonservice.service.RecaptchaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ReCaptchaController {

    @Autowired
    RecaptchaService recaptchaService;

   @GetMapping("/index")
    public String index() {
        return "index";
    }

    @PostMapping("/api/v1/saveScore")
    public String saveScore(@RequestBody TokenResource tokenResource) throws Exception {
        return recaptchaService.checkValidity(tokenResource.getToken());
    }
}
