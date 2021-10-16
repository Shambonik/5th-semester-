package com.example.stupid_jokes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;


@AllArgsConstructor
@Getter
public class GetUserDto {
    String login;
    String fullName;
    List<GetJokeDto> jokes;
}
