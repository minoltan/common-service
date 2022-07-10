package com.amitech.springcommonservice.client;

import com.amitech.springcommonservice.response.RecaptchaResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class GoogleRecaptchaClient {
    private String mSpaceHost = "https://www.google.com/recaptcha/api/siteverify";
    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(GoogleRecaptchaClient.class);

    @Autowired
    public GoogleRecaptchaClient(RestTemplate restTemplate) {
        this.restTemplate  = restTemplate;
    }

    public RecaptchaResponse checkScore(String token) throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(mSpaceHost)
                    .queryParam("secret", "6LfqNpQgAAAAACXR6d-2DaOPADtr2y0UKvBDYlwX")
                    .queryParam("response", token);
            ResponseEntity<String> exchange = restTemplate.exchange(builder.toUriString(), HttpMethod.POST, null, String.class);
            return new ObjectMapper().readValue(exchange.getBody(), RecaptchaResponse.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            logger.error("Error response : State code: {}, response: {} ", e.getStatusCode(), e.getResponseBodyAsString());
            throw e;
        } catch (Exception err) {
            logger.error("Error: {} ", err.getMessage());
            throw new Exception("This service is not available at the moment!");
        }

    }

}
