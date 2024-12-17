package org.example.donationms.controllers;

import org.example.donationms.entities.Donation;
import org.example.donationms.models.Organisation;
import org.example.donationms.models.User;
import org.example.donationms.repos.DonationRepo;
import org.example.donationms.service.OrganisationRestClient;
import org.example.donationms.service.UserRestClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DonationRestController {
    DonationRepo donationRepo;
    UserRestClient userRestClient;
    OrganisationRestClient organisationRestClient;

    public DonationRestController(DonationRepo donationRepo, UserRestClient userRestClient,
                                  OrganisationRestClient organisationRestClient) {
        this.donationRepo = donationRepo;
        this.userRestClient = userRestClient;
        this.organisationRestClient = organisationRestClient;
    }

    @GetMapping
    public List<Donation> getAllDonations() {
        return donationRepo.findAll();
    }

    @GetMapping("/donations/{id}")
    public Donation getDonationById(@PathVariable Long id) {
        Long userId = 1L;
        Long organisationId = 1L;
        Donation donation = donationRepo.findById(id).get();
        User user = userRestClient.getUserById(userId);
        Organisation organisation = organisationRestClient.getOrganisationById(organisationId);
        donation.setIdUser(user.getId());
        donation.setIdOrganisation(organisation.getId());
        return donation;
    }
}
