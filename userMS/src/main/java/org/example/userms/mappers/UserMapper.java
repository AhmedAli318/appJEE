package org.example.userms.mappers;


import org.example.userms.dtos.UserDTOResponse;
import org.example.userms.entities.User;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserDTOResponse fromUser(User user){
        UserDTOResponse userDTOResponse = new UserDTOResponse();
        BeanUtils.copyProperties(user,userDTOResponse);
        return userDTOResponse;
    }
}
