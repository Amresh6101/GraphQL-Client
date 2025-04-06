package com.graphqlclient.controller;


import com.graphqlclient.dto.UserRequestDTO;
import com.graphqlclient.dto.UserResponseDTO;
import com.graphqlclient.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserClientService userClientService;

    @GetMapping("/users")
    public List<UserResponseDTO> getAllUsers(){
        return userClientService.listAllUsers();
    }

    @GetMapping("/user/{id}")
    public UserResponseDTO fetchUserById(@PathVariable Integer id){
        return userClientService.listUserById(id);
    }

    @PostMapping("/adduser")
    public UserResponseDTO addUser(@RequestBody UserRequestDTO userRequestDTO){
        return userClientService.addUser(userRequestDTO);
    }

    @DeleteMapping("deleteuser/{id}")
    public  Boolean deleteUser(@PathVariable Integer id){
        return userClientService.deleteUser(id);
    }
}
