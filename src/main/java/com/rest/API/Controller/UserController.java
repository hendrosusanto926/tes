package com.rest.API.controller;


import com.rest.API.model.User;
import com.rest.API.repository.UserRepository;
import java.awt.print.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import javax.persistence.Id;

@RestController
public class UserController {

@Autowired
    UserRepository userRepository;

    @GetMapping("/User")
    public List<User> getAllNotes() {
        return UserRepository.findAll();
    }

    @PostMapping("/User")
    public User createNote(@Valid @RequestBody User user) {
        return userRepository.save(user);
    }

    @GetMapping("/User/{id}")
    public Optional<User> getUserById(@PathVariable(value = "id") Long Id){
        return UserRepository.findById(Id)
    }


User user = UserRepository.findById(Id);


}