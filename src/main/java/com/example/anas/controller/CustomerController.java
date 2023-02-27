package com.example.anas.controller;


import com.example.anas.dto.CustomerDTO;
import com.example.anas.model.Customer;
import com.example.anas.model.MyUser;
import com.example.anas.service.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/all")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customers = customerService.getAllCustomers();
        return ResponseEntity.status(200).body(customers);
    }


    // TODO: assign order to customer
    @PostMapping("/addCustomer")
    public ResponseEntity assignCustomerToUser(@RequestBody @Valid CustomerDTO customerDTO, @AuthenticationPrincipal MyUser myUser) {
        customerService.assignCustomerToUser(customerDTO, myUser.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body("assign customer as user registered!");
    }



}
