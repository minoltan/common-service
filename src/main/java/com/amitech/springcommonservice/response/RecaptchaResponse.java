package com.amitech.springcommonservice.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RecaptchaResponse {
    @JsonProperty("success")
    Boolean success;
    @JsonProperty("score")
    Double score;
    @JsonProperty("action")
    String action;
    @JsonProperty("challenge_ts")
    String challenge_ts;
    @JsonProperty("hostname")
    String hostname;
    @JsonProperty("error-codes")
    List<String> errorCodes;

    public RecaptchaResponse() {
    }

    public RecaptchaResponse(Boolean success, Double score, List<String> errorCodes) {
        this.success = success;
        this.score = score;
        this.errorCodes = errorCodes;
    }

    public RecaptchaResponse(Boolean success, Double score, String action, String challenge_ts, String hostname, List<String> errorCodes) {
        this.success = success;
        this.score = score;
        this.action = action;
        this.challenge_ts = challenge_ts;
        this.hostname = hostname;
        this.errorCodes = errorCodes;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public List<String> getErrorCodes() {
        return errorCodes;
    }

    public void setErrorCodes(List<String> errorCodes) {
        this.errorCodes = errorCodes;
    }

    @Override
    public String toString() {
        return "RecaptchaResponse{" +
                "success=" + success +
                ", score=" + score +
                ", action='" + action + '\'' +
                ", challenge_ts='" + challenge_ts + '\'' +
                ", hostname='" + hostname + '\'' +
                ", errorCodes=" + errorCodes +
                '}';
    }
}
