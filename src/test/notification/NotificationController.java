package com.prathiksh.security.notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/v1")
public class NotificationController {

    @Autowired
    private NotificationServiceImpl notificationService;

    @GetMapping("/messages")
    public List<String> getMessageTypes(){
        return notificationService.getMessageTypes();
    }


}
