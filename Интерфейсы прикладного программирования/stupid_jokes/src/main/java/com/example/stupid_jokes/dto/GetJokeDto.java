package com.example.stupid_jokes.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GetJokeDto {
    String name;
    String jokeText;
    String fullName;
}
