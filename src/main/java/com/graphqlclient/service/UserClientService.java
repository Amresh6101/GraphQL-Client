package com.graphqlclient.service;

import com.graphqlclient.client.UserECommClient;
import com.graphqlclient.dto.UserRequestDTO;
import com.graphqlclient.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserClientService {

    @Autowired
    private UserECommClient userECommClient;

    public List<UserResponseDTO> listAllUsers(){
        return userECommClient.listAllUsers();
    }

    public  UserResponseDTO listUserById(Integer id){
        return userECommClient.listUserByID(id);
    }

    public UserResponseDTO addUser(UserRequestDTO userRequestDTO){
        return userECommClient.addUser(userRequestDTO);
    }
    public  Boolean deleteUser(Integer id){
        return userECommClient.deleteUserById(id);
    }
}
