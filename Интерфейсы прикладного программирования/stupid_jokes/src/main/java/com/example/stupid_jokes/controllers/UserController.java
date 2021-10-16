package com.example.stupid_jokes.controllers;

import com.example.stupid_jokes.dto.AddUserDto;
import com.example.stupid_jokes.dto.EditUserDto;
import com.example.stupid_jokes.dto.GetUserDto;
import com.example.stupid_jokes.entities.User;
import com.example.stupid_jokes.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public GetUserDto getUser(@RequestParam("login") String login) {
        return userService.getUser(login);
    }

    @PostMapping("/add")
    public User addUser(@RequestBody AddUserDto dto) {
        return userService.addUser(dto);
    }

    @PutMapping("/edit")
    public User editUser(@RequestBody EditUserDto dto){
        return userService.editUser(dto);
    }

    @DeleteMapping("/delete")
    public Boolean deleteUser(@RequestParam("login") String login){
        return userService.deleteUser(login);
    }
}
