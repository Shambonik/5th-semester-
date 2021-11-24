package com.example.pr4.controller;

import com.example.pr4.model.Message;
import com.example.pr4.model.OutputMessage;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class MessageController {

    @MessageMapping("/webs")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message){
        String time = new SimpleDateFormat("HH:mm").format(new Date());
        return new OutputMessage(message.getText(), time);
    }

}
