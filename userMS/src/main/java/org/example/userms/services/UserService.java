package org.example.userms.services;


import org.example.userms.dtos.UserDTORequest;
import org.example.userms.dtos.UserDTOResponse;

public interface UserService {
    UserDTOResponse addUser(UserDTORequest userDTORequest);
    UserDTOResponse updateUser(Long id, UserDTORequest userDTORequest);
    void deleteUser(Long id);
}
