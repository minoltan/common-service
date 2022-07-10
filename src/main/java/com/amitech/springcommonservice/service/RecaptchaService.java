package com.amitech.springcommonservice.service;

import com.amitech.springcommonservice.client.GoogleRecaptchaClient;
import com.amitech.springcommonservice.response.RecaptchaResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class RecaptchaService {

    @Autowired
    private GoogleRecaptchaClient googleRecaptchaClient;

    public String checkValidity(String token) throws Exception {
        if ("FIRST_TIME".equals(token)) {
            return "FIRST_TIME";
        }
        else {
            RecaptchaResponse recaptchaResponse = googleRecaptchaClient.checkScore(token);
            if (!recaptchaResponse.getSuccess()) {
                if("timeout-or-duplicate".equals(recaptchaResponse.getErrorCodes().get(0))){
                    return "timeout-or-duplicate";
                }else{
                    return "Error: " + recaptchaResponse.getErrorCodes().get(0);
                }
            }
            else if (recaptchaResponse.getSuccess() && recaptchaResponse.getScore() <= 0.5) {
                return "Score: " + recaptchaResponse.getScore();
            }
            else if (recaptchaResponse.getSuccess() && recaptchaResponse.getScore() > 0.5) {
                return "Score: " + recaptchaResponse.getScore();
            }
        }
        return token;
    }

}
