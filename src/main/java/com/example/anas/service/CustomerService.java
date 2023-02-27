package com.example.anas.service;


import com.example.anas.api.ApiException;
import com.example.anas.dto.CustomerDTO;
import com.example.anas.model.Customer;
import com.example.anas.model.MyUser;
import com.example.anas.repository.CustomerRepository;
import com.example.anas.repository.MyUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;
    private final MyUserRepository myUserRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }
    public void assignCustomerToUser(CustomerDTO customerDTO, Integer auth_id) {
        MyUser myUser = myUserRepository.findMyUserById(auth_id);
        if(myUser == null) {
            throw new ApiException("user not found!");
        } else if(myUser.getCustomer() == null) {
            throw new ApiException("Customer not found!");
        }
        myUserRepository.save(myUser);
        Customer customer = new Customer(null, customerDTO.getName(), myUser);
        customerRepository.save(customer);
    }



}
