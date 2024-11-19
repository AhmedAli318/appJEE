package org.example.userms.web;


import org.example.userms.dtos.UserDTORequest;
import org.example.userms.dtos.UserDTOResponse;
import org.example.userms.entities.User;
import org.example.userms.repos.UserRepo;
import org.example.userms.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserGraphqlController {
    @Autowired
    private UserRepo userRepo;
    private UserService userService;
    @QueryMapping
    private List<User> users(){
        return userRepo.findAll();
    }
    @QueryMapping(name = "user")
    private User userById(@Argument Long id){
        return userRepo.findById(id)
                .orElseThrow(()-> new RuntimeException("User not found"));
    }
    @MutationMapping
    private UserDTOResponse addUser(@Argument UserDTORequest userDTORequest){
        return userService.addUser(userDTORequest);
    }
    @MutationMapping
    private UserDTOResponse updateUser(@Argument Long id,@Argument UserDTORequest userDTORequest){
        return userService.updateUser(id,userDTORequest);
    }
    @MutationMapping
    private void deleteUser(@Argument Long id){
        userService.deleteUser(id);
    }
}
