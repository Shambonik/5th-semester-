package com.example.stupid_jokes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AddUserDto {
    String login;
    String fullName;
}
