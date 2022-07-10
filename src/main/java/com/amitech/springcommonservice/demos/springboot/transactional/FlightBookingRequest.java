package com.amitech.springcommonservice.demos.springboot.transactional;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FlightBookingRequest {
    @JsonProperty("passenger_info")
    private PassengerInfo passengerInfo;
    @JsonProperty("payment_info")
    private PaymentInfo paymentInfo;
}
