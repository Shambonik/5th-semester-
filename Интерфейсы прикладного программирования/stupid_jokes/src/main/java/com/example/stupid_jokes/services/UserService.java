package com.example.stupid_jokes.services;

import com.example.stupid_jokes.dto.AddUserDto;
import com.example.stupid_jokes.dto.EditUserDto;
import com.example.stupid_jokes.dto.GetJokeDto;
import com.example.stupid_jokes.dto.GetUserDto;
import com.example.stupid_jokes.entities.Joke;
import com.example.stupid_jokes.entities.User;
import com.example.stupid_jokes.repos.JokeRepo;
import com.example.stupid_jokes.repos.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final JokeRepo jokeRepo;
    private final UserRepo userRepo;

    public GetUserDto getUser(String login){
        User user = userRepo.findByLogin(login);
        List<Joke> jokes = jokeRepo.findAllByUser(user);
        if(user!=null) {
            return new GetUserDto(login, user.getFullName(), jokes.stream()
                    .map(joke -> new GetJokeDto(joke.getName(), joke.getJokeText(), user.getFullName()))
                    .collect(Collectors.toList())
            );
        }
        return null;
    }

    public User addUser(AddUserDto dto){
        User user = new User();
        user.setJokes(new HashSet<>());
        user.setLogin(dto.getLogin());
        user.setFullName(dto.getFullName());
        return userRepo.save(user);
    }

    public User editUser(EditUserDto dto){
        User user = userRepo.findByLogin(dto.getLogin());
        if(user!=null){
            user.setFullName(dto.getFullName());
            return userRepo.save(user);
        }
        return null;
    }

    public Boolean deleteUser(String login){
        User user = userRepo.findByLogin(login);
        if(user==null){
            return false;
        }
        List<Joke> jokes = jokeRepo.findAllByUser(user);
        for(Joke joke : jokes){
            jokeRepo.delete(joke);
        }
        userRepo.delete(user);
        return true;
    }


}
