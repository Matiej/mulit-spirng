package com.emat.multispirng.controllers;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@RestController
public class IntroduceController {

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Map<String, Object>> getIndex() {
        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("Hello", "World");

        return ResponseEntity.ok()
                .headers(getSuccessfulHeaders(HttpStatus.OK, HttpMethod.GET))
                .body(responseMap);
    }

    public static HttpHeaders getSuccessfulHeaders(HttpStatus status, HttpMethod... allowMethods) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add(HttpHeaders.ACCESS_CONTROL_ALLOW_METHODS, Arrays.toString(allowMethods));
        httpHeaders.add("Status", status.name());
        httpHeaders.add("Message", "Successful");
        return httpHeaders;
    }
}
