package org.example.userms.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.userms.enums.Gender;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTOResponse {
    private String firstName;
    private String lastName;
    private String email;
    private Date birthDate;
    private String CIN;
    private String phoneNumber;
    private String address;
    private Gender gender;
    private Boolean enabled;
}
