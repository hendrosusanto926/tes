package com.rest.API.controller;


import com.rest.API.model.Shopping;
import com.rest.API.repository.ShoppingRepository;
import java.awt.print.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import javax.persistence.Id;

@RestController
public class ShoppingController {

@Autowired
    ShoppingRepository ShoppingRepository;

    @GetMapping("/Shopping")
    public List<Shopping> getAllNotes() {
        return ShoppingRepository.findAll();
    }

    @PostMapping("/Shopping")
    public Shopping createNote(@Valid @RequestBody Shopping shopping) {
        return shoppingRepository.save(shopping);
    }

    @GetMapping("/Shopping/{id}")
    public Optional<Shopping> getShoppingById(@PathVariable(value = "id") Long Id){
        return ShoppingRepository.findById(Id)
    }



Shopping shopping = ShoppingRepository.findById(Id);


}