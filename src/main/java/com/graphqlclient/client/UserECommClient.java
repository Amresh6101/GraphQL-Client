package com.graphqlclient.client;


import com.graphqlclient.dto.UserRequestDTO;
import com.graphqlclient.dto.UserResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserECommClient {

    @Autowired
    private HttpGraphQlClient graphQlClient;

    //ListAllUsers
    public List<UserResponseDTO> listAllUsers(){
        String query= """
                query{
                  getAllUsers{
                    name
                    id 
                    email
                    address
                    phoneNumber
                  }
                }
                """;
        return graphQlClient.document(query)
                .retrieve("getAllUsers")
                .toEntityList(UserResponseDTO.class)
                .block();
    }

    //ListUserById
    public UserResponseDTO listUserByID(Integer id){
        String query= """
                query($id: ID!){
                  getUserById(id: $id){
                    name
                    id
                    email                    
                  }
                }
                """;
        return graphQlClient
                .document(query)
                .variable("id", id)
                .retrieve("getUserById")
                .toEntity(UserResponseDTO.class)
                .block();

        // we are using block to make things synchronously, this operation will wait until its completion
        // we can use some stream as well as Mono type
    }

    //addUser
    public UserResponseDTO addUser(UserRequestDTO userRequestDTO) {
        String mutation = """
        mutation CreateUser($name: String, $address: String, $email: String, $password: String, $phoneNumber: String) {
          createUser(
            name: $name,
            address: $address,
            email: $email,
            password: $password,
            phoneNumber: $phoneNumber
          ) {
            id
            name
            email
          }
        }
    """;

        return graphQlClient.document(mutation)
                .variable("name", userRequestDTO.getName())
                .variable("address", userRequestDTO.getAddress())
                .variable("email", userRequestDTO.getEmail())
                .variable("password", userRequestDTO.getPassword())
                .variable("phoneNumber", userRequestDTO.getPhoneNumber())
                .retrieve("createUser")
                .toEntity(UserResponseDTO.class)
                .block();
    }


    // deleteUser
    public Boolean deleteUserById(Integer id) {
        String mutation = """
            mutation DeleteUser($id: ID!) {
              deleteUser(id: $id)
            }
            """;

        return graphQlClient.document(mutation)
                .variable("id", id)
                .retrieve("deleteUser")
                .toEntity(Boolean.class)
                .block();
    }

}
