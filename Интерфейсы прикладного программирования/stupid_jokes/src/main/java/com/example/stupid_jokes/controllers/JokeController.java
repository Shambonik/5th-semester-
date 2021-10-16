package com.example.stupid_jokes.controllers;

import com.example.stupid_jokes.dto.AddJokeDto;
import com.example.stupid_jokes.dto.GetJokeDto;
import com.example.stupid_jokes.entities.Joke;
import com.example.stupid_jokes.services.JokeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/joke")
@RequiredArgsConstructor
public class JokeController {

    private final JokeService jokeService;

    @GetMapping("/get")
    public GetJokeDto getJoke(@RequestParam("name") String name) {
       return jokeService.getJoke(name);
    }

    @PostMapping("/add")
    public Joke addJoke(@RequestBody AddJokeDto dto) {
        return jokeService.addJoke(dto);
    }
}
