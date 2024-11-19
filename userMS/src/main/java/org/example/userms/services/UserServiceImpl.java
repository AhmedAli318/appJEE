package org.example.userms.services;


import jakarta.transaction.Transactional;
import org.example.userms.dtos.UserDTORequest;
import org.example.userms.dtos.UserDTOResponse;
import org.example.userms.entities.User;
import org.example.userms.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepo userRepo;

    @Override
    public UserDTOResponse addUser(UserDTORequest userDTORequest) {
        User user = new User();
        user.setFirstName(userDTORequest.getFirstName());
        user.setLastName(userDTORequest.getLastName());
        user.setEmail(userDTORequest.getEmail());
        user.setBirthDate(new Date());
        user.setCIN(userDTORequest.getCIN());
        user.setPhoneNumber(userDTORequest.getPhoneNumber());
        user.setAddress(userDTORequest.getAddress());
        user.setEnabled(Boolean. TRUE);
        User savedUser = userRepo.save(user) ;
        UserDTOResponse userDTOResponse = new UserDTOResponse();
        userDTOResponse.setFirstName(savedUser.getFirstName());
        userDTOResponse.setLastName(savedUser.getLastName());
        userDTOResponse.setEmail(savedUser.getEmail());
        userDTOResponse.setBirthDate(savedUser.getBirthDate());
        userDTOResponse.setCIN(savedUser.getCIN());
        userDTOResponse.setPhoneNumber(savedUser.getPhoneNumber());
        userDTOResponse.setAddress(savedUser.getAddress());
        userDTOResponse.setEnabled(savedUser.getEnabled());
        return userDTOResponse;
    }

    @Override
    public UserDTOResponse updateUser(Long id, UserDTORequest userDTORequest) {
        Optional<User> optionalUser = userRepo.findById(id);
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            user.setFirstName(userDTORequest.getFirstName());
            user.setLastName(userDTORequest.getLastName());
            user.setEmail(userDTORequest.getEmail());
            user.setBirthDate(new Date());
            user.setCIN(userDTORequest.getCIN());
            user.setPhoneNumber(userDTORequest.getPhoneNumber());
            user.setAddress(userDTORequest.getAddress());
            user.setEnabled(Boolean. TRUE);
            User savedUser = userRepo.save(user) ;
            UserDTOResponse userDTOResponse = new UserDTOResponse();
            userDTOResponse.setFirstName(savedUser.getFirstName());
            userDTOResponse.setLastName(savedUser.getLastName());
            userDTOResponse.setEmail(savedUser.getEmail());
            userDTOResponse.setBirthDate(savedUser.getBirthDate());
            userDTOResponse.setCIN(savedUser.getCIN());
            userDTOResponse.setPhoneNumber(savedUser.getPhoneNumber());
            userDTOResponse.setAddress(savedUser.getAddress());
            userDTOResponse.setEnabled(savedUser.getEnabled());
            return userDTOResponse;
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }
    @Override
    public void deleteUser(Long id){
        if (userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }
}

