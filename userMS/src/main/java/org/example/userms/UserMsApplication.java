package org.example.userms;


import org.example.userms.entities.User;
import org.example.userms.enums.Gender;
import org.example.userms.repos.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class UserMsApplication implements CommandLineRunner {
    @Autowired
    private UserRepo userRepo;
    public static void main(String[] args) {
        SpringApplication.run(UserMsApplication.class, args);}
    @Override
    public void run(String...args) throws Exception {
        for (int i = 1; i <= 10; i++) {
            userRepo.save(new User(i,"User "+i,"user "+i,"user"+i+"@gmail.com",new Date(),"CIN "+i,"066777777"+i,"Adresse User "+i, (i%2 == 0) ? Gender.MALE : Gender.FEMALE, (i%2 == 0) ? Boolean.FALSE : Boolean.TRUE));
        }
    }
}
