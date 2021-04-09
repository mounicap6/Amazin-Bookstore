package com.amazon.bookstore;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MessageHandlingController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public String send(String title) throws Exception {
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return title;
    }
}

