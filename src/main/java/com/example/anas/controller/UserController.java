package com.example.anas.controller;



import com.example.anas.model.MyUser;
import com.example.anas.service.MyUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {

    private final MyUserService myUserService;

    @GetMapping("/all")
    public ResponseEntity<List<MyUser>> getAllUsers() {
        List<MyUser> customers = myUserService.getAllMyUsers();
        return ResponseEntity.status(200).body(customers);
    }
        @PostMapping("/login")
    public ResponseEntity customerLogin() {
        return ResponseEntity.status(HttpStatus.OK).body("Customer logged in successfully");
    }
    @PostMapping("/logout")
    public ResponseEntity customerLogout() {
        return ResponseEntity.status(HttpStatus.OK).body("Customer logout in successfully");
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody MyUser myUser) {
        myUserService.register(myUser);
        return ResponseEntity.status(HttpStatus.OK).body("good");
    }



}
