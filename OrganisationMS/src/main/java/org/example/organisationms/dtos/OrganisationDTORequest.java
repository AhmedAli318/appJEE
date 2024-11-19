package org.example.organisationms.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrganisationDTORequest {

    private String name;

    private String address;

    private String phoneNumber;

    private String email;

    private Date createdAt;

    private Date updatedAt;
}
