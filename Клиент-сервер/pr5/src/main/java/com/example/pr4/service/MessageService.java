package com.example.pr4.service;

import com.example.pr4.dto.MessageDTO;
import com.example.pr4.dto.MessageInputDTO;
import com.example.pr4.dto.OutputDTO;
import com.example.pr4.model.Message;
import com.example.pr4.repo.MessageRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.messaging.simp.SimpMessageType;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MessageService {
    private final MessageRepo messageRepo;
    private final SimpMessagingTemplate messagingTemplate;

    public OutputDTO send(MessageInputDTO dto) {
        Message message = new Message();
        message.setText(dto.getText());
        message.setTime(LocalDateTime.now());
        messageRepo.save(message);
        OutputDTO output = new OutputDTO();
        output.setMessages(Collections.singletonList(
                new MessageDTO(message.getText(), message.getTime().toString())
        ));
        return output;
    }


    public void sendAllMessages(String sessionId){
        List<Message> messages = messageRepo.findAll();
        OutputDTO output = new OutputDTO();
        output.setMessages(messages.stream()
                .map(message -> new MessageDTO(message.getText(), message.getTime().toString()))
                .collect(Collectors.toList())
        );
        SimpMessageHeaderAccessor headerAccessor =
                SimpMessageHeaderAccessor.create(SimpMessageType.MESSAGE);
        headerAccessor.setSessionId(sessionId);
        headerAccessor.setLeaveMutable(true);
        messagingTemplate.convertAndSend("/topic/messages-" + sessionId, output);
    }
}
