package org.example.donationms.models;

import lombok.Data;

@Data
public class Organisation {
    private Long id;
    private String name;
    private String address;
    private String phonenumber;
    private String email;
}
