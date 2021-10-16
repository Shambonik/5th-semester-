package com.example.stupid_jokes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String login;
    String fullName;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    Set<Joke> jokes;
}
