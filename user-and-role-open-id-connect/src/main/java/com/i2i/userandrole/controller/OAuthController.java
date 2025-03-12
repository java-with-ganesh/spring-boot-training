package com.i2i.userandrole.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OAuthController {
    @RequestMapping
    public String userInfo(){
        return "success";
    }
}
