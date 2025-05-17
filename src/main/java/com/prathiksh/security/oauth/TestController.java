package com.prathiksh.security.oauth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/home")
    public String testOauth(){
        return "Hi OAuth Successfully Authenticated";
    }


}
