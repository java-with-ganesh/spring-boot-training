package com.i2i.service;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@org.springframework.cloud.openfeign.FeignClient(name = "user-role")
public interface FeignClient {

    @GetMapping("${app.user.url}/users/validate")
    boolean validateUser(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization);
}
