package com.example.anas.service;


import com.example.anas.model.MyUser;
import com.example.anas.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyUserService {

    private final MyUserRepository myUserRepository;


    public List<MyUser> getAllMyUsers() {
        return myUserRepository.findAll();
    }


    public void register(MyUser user) {
        user.setRole("customer");
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        myUserRepository.save(user);
    }

}