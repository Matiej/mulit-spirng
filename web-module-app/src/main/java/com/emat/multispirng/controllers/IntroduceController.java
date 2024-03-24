package com.emat.multispirng.controllers;

import com.emat.model.ShippingAddress;
import com.emat.model.User;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class IntroduceController {

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserDataResponse> getIndex() {

        return ResponseEntity.ok()
                .headers(getSuccessfulHeaders(HttpStatus.OK, HttpMethod.GET))
                .body(prepareFakeResponseData());
    }

    public static HttpHeaders getSuccessfulHeaders(HttpStatus status, HttpMethod... allowMethods) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, Arrays.toString(allowMethods));
        httpHeaders.add("Status", status.name());
        httpHeaders.add("Message", "Successful");
        return httpHeaders;
    }

    private UserDataResponse prepareFakeResponseData() {
        User user = new User("John", "Smith", "email@email.ce", 44);
        ShippingAddress shippingAddress = new ShippingAddress();
        shippingAddress.setCity("Warszawa");
        shippingAddress.setPostalCode("05050");
        shippingAddress.setBuildingNumber("23a");
        shippingAddress.setStreet("SuperLongStr");
        return new UserDataResponse(user, shippingAddress);
    }
}
