package com.example.stupid_jokes.repos;

import com.example.stupid_jokes.entities.Joke;
import com.example.stupid_jokes.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JokeRepo extends JpaRepository<Joke, Long> {
    Joke findByName(String name);
    List<Joke> findAllByUser(User user);
}
