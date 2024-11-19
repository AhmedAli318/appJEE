package org.example.organisationms;


import org.example.organisationms.entities.Organisation;
import org.example.organisationms.repos.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class OrganisationMsApplication implements CommandLineRunner {
    @Autowired
    private OrganisationRepo organisationRepo;
    public static void main(String[] args) {

        SpringApplication.run(OrganisationMsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        for (int i = 1; i <= 10; i++) {
            organisationRepo.save(new Organisation(i,"Organisation "+i,"Adresse Organisation "+i,"066666667"+i,"organisation"+i+"@gmail.com",new Date(),new Date()));
        }
    }
}
