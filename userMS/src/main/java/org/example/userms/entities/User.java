package org.example.userms.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.userms.enums.Gender;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50,nullable = false)
    private String firstName;

    @Column(length = 50,nullable = false)
    private String lastName;

    @Column(length = 150, nullable = false)
    private String email;

    @Temporal(TemporalType.DATE) @Column(nullable = false)
    private Date birthDate;

    @Column(length = 8, unique = true, nullable = false)
    private String CIN;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(length = 100,nullable = false)
    private String address;

    @Column(nullable = false) @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(nullable = false)
    private Boolean enabled;
}
