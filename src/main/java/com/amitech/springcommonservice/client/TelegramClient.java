package com.amitech.springcommonservice.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class TelegramClient {

//    private String token = "5532040960:AAEs0C6f88l8T45NmGSCki59NwwEy6V-viM";

    private String imi_token = "5573816146:AAHhq43lbONOZ9k9lie1ddCxi4McgFn09BE";
    private String telegramBaseUrl = "https://api.telegram.org/bot";
    private String apiUrl = telegramBaseUrl+imi_token;

    private final RestTemplate restTemplate;
    private static final Logger logger = LoggerFactory.getLogger(TelegramClient.class);

    @Autowired
    public TelegramClient(RestTemplate restTemplate) {
        this.restTemplate  = restTemplate;
    }

    public void sendMessage(String message, String chatID) throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();
            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl+"/sendMessage")
                    .queryParam("chat_id", chatID)
                    .queryParam("text", message);
            ResponseEntity<String> exchange = restTemplate.exchange(builder.toUriString().replaceAll("%20", " "), HttpMethod.GET, null, String.class);

        } catch (HttpClientErrorException | HttpServerErrorException e) {
            logger.error("Error response : State code: {}, response: {} ", e.getStatusCode(), e.getResponseBodyAsString());
            throw e;
        } catch (Exception err) {
            logger.error("Error: {} ", err.getMessage());
            throw new Exception("This service is not available at the moment!");
        }
    }

    public void sendPhotoFile(String chatID, String caption, MultipartFile photo) throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.MULTIPART_FORM_DATA);
            MultiValueMap<String, Object> body = new LinkedMultiValueMap<>();

            ByteArrayResource fileAsResource = new ByteArrayResource(photo.getBytes()){
                @Override
                public String getFilename(){
                    return photo.getOriginalFilename();
                }
            };

            body.add("Content-Type", "image/png");
            body.add("photo", fileAsResource);
            HttpEntity<MultiValueMap<String, Object>> requestEntity = new HttpEntity<>(body, headers);

            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl+"/sendPhoto")
                    .queryParam("chat_id", chatID)
                    .queryParam("caption", caption);

            System.out.println(requestEntity);
            String exchange = restTemplate.postForObject(
                    builder.toUriString().replaceAll("%20", " "),
                    requestEntity,
                    String.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            logger.error("Error response : State code: {}, response: {} ", e.getStatusCode(), e.getResponseBodyAsString());
            throw e;
        } catch (Exception err) {
            logger.error("Error: {} ", err.getMessage());
            throw new Exception("This service is not available at the moment!");
        }
    }

    public void sendPhoto(String chatID, String caption, String photo) throws Exception {
        try {
            RestTemplate restTemplate = new RestTemplate();


            UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl+"/sendPhoto")
                    .queryParam("chat_id", chatID)
                    .queryParam("photo", photo)
                    .queryParam("caption", caption);

            String exchange = restTemplate.postForObject(
                    builder.toUriString().replaceAll("%20", " "),
                    null,
                    String.class);
        } catch (HttpClientErrorException | HttpServerErrorException e) {
            logger.error("Error response : State code: {}, response: {} ", e.getStatusCode(), e.getResponseBodyAsString());
            throw e;
        } catch (Exception err) {
            logger.error("Error: {} ", err.getMessage());
            throw new Exception("This service is not available at the moment!");
        }
    }

}
