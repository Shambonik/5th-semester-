package com.example.pr4.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class OutputDTO {
    List<MessageDTO> messages;
}
