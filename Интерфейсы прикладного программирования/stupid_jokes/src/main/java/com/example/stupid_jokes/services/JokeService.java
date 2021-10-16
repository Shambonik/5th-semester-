package com.example.stupid_jokes.services;

import com.example.stupid_jokes.dto.AddJokeDto;
import com.example.stupid_jokes.dto.GetJokeDto;
import com.example.stupid_jokes.entities.Joke;
import com.example.stupid_jokes.entities.User;
import com.example.stupid_jokes.repos.JokeRepo;
import com.example.stupid_jokes.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@RequiredArgsConstructor
public class JokeService {

    private final JokeRepo jokeRepo;
    private final UserRepo userRepo;


    public GetJokeDto getJoke(String name){
        Joke joke = jokeRepo.findByName(name);
        if(joke!=null) {
            if(joke.getUser() == null){
                return new GetJokeDto(name, joke.getJokeText(), null);
            }
            return new GetJokeDto(name, joke.getJokeText(), joke.getUser().getFullName());
        }
        return null;
    }

    public Joke addJoke(AddJokeDto dto){
        Joke joke = new Joke();
        joke.setJokeText(dto.getJokeText());
        joke.setName(dto.getName());
        User user = userRepo.findByLogin(dto.getLogin());
        joke.setUser(user);
        return jokeRepo.save(joke);
    }
}
