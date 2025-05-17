package com.prathiksh.security.notification;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class NotificationServiceImpl {

    public List<String> getMessageTypes() {
        return Arrays.asList("Email","SMS","PushNotifications");
    }

}
