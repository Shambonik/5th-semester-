package com.example.stupid_jokes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class EditUserDto {
    String login;
    String fullName;
}
