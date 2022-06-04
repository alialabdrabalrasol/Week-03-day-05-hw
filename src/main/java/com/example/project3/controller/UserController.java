package com.example.project3.controller;

import com.example.project3.dto.ResponseAPI;
import com.example.project3.model.User;
import com.example.project3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
public class UserController {
    Logger log= LoggerFactory.getLogger(UserController.class);
    private final UserService userService;
    @GetMapping
    public ResponseEntity getUsers(){
        log.info("users are retrieved through getUsers() - UserController");
        return ResponseEntity.status(HttpStatus.OK).body(userService.getUsers());
    }
    @PostMapping
    public ResponseEntity addUser(@RequestBody @Valid User user){
        log.info("a user is being added through addUser() - UserController");
        userService.addUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseAPI("User added",HttpStatus.CREATED.value()));
    }
}
