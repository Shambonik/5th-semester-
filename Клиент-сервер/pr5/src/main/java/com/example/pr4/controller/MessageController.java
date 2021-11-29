package com.example.pr4.controller;

import com.example.pr4.dto.MessageInputDTO;
import com.example.pr4.dto.OutputDTO;
import com.example.pr4.model.Message;
import com.example.pr4.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequiredArgsConstructor
public class MessageController {
    private final MessageService messageService;

    @MessageMapping("/webs")
    @SendTo("/topic/messages")
    public OutputDTO send(MessageInputDTO messageInputDTO){
        return messageService.send(messageInputDTO);
    }

    @MessageMapping("/get_all")
    public void sendAll(@Header("simpSessionId") String sessionId){
        messageService.sendAllMessages(sessionId);
    }
}
