package com.amitech.springcommonservice.resource;

public class TokenResource {


    private String token;

    public TokenResource() {
    }

    public TokenResource(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "tokenResource{" +
                "token='" + token + '\'' +
                '}';
    }
}
