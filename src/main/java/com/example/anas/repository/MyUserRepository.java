package com.example.anas.repository;

import com.example.anas.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Integer> {

    MyUser findMyUserById (Integer id);
    MyUser findMyUserByUsername(String username);


}
