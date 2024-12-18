package org.example.donationms;

import org.example.donationms.entities.Donation;
import org.example.donationms.models.Organisation;
import org.example.donationms.models.User;
import org.example.donationms.repos.DonationRepo;
import org.example.donationms.service.OrganisationRestClient;
import org.example.donationms.service.UserRestClient;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import java.util.Date;

@SpringBootApplication
@EnableFeignClients
public class DonationMsApplication implements CommandLineRunner {

    private final UserRestClient userRestClient;
    private final OrganisationRestClient organisationRestClient;
    private final DonationRepo donationRepo;

    public DonationMsApplication(UserRestClient userRestClient, OrganisationRestClient organisationRestClient,
                                 DonationRepo donationRepo) {
        this.userRestClient = userRestClient;
        this.organisationRestClient = organisationRestClient;
        this.donationRepo = donationRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(DonationMsApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*Long userId = 1L;
        Long organisationId = 1L;
        User user = userRestClient.getUserById(userId);
        Organisation organisation = organisationRestClient.getOrganisationById(organisationId);
        Donation donation = new Donation();
        donation.setDateDonation(new Date());
        donation.setMontant(500.0);
        donation.setIdUser(user.getId());
        donation.setIdOrganisation(organisation.getId());
        //donation.setUser(user);
        //donation.setOrganisation(organisation);
        donationRepo.save(donation);*/
    }
}
