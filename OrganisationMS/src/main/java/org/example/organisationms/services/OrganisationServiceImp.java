package org.example.organisationms.services;


import org.example.organisationms.dtos.OrganisationDTORequest;
import org.example.organisationms.dtos.OrganisationDTOResponse;
import org.example.organisationms.entities.Organisation;
import org.example.organisationms.repos.OrganisationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganisationServiceImp implements OrganisationService{
    @Autowired
    OrganisationRepo organisationRepo;

    @Override
    public List<Organisation> findOrganisations() {
        return organisationRepo.findAll();

    }

    @Override
    public OrganisationDTOResponse addOrganisation(OrganisationDTORequest organisationDTORequest) {
        Organisation organisation = new Organisation();
        organisation.setName(organisation.getName());
        organisation.setAddress(organisation.getAddress());
        organisation.setPhoneNumber(organisation.getPhoneNumber());
        organisation.setEmail(organisation.getEmail());
        Organisation savedorganisation = organisationRepo.save(organisation);
        OrganisationDTOResponse organisationDTOResponse = new OrganisationDTOResponse();
        organisationDTOResponse.setName(savedorganisation.getName());
        organisationDTOResponse.setAddress(savedorganisation.getAddress());
        organisationDTOResponse.setPhoneNumber(savedorganisation.getPhoneNumber());
        organisationDTOResponse.setPhoneNumber(savedorganisation.getPhoneNumber());
        return organisationDTOResponse;
    }

    @Override
    public OrganisationDTOResponse updateOrganisation(Long id,OrganisationDTORequest organisationDTORequest) {
        Optional<Organisation> optionalOrganisation = organisationRepo.findById(id);
        if (optionalOrganisation.isPresent()) {
            Organisation organisation = optionalOrganisation.get();
            organisation.setName(organisation.getName());
            organisation.setAddress(organisation.getAddress());
            organisation.setPhoneNumber(organisation.getPhoneNumber());
            organisation.setEmail(organisation.getEmail());
            Organisation savedorganisation = organisationRepo.save(organisation);
            OrganisationDTOResponse organisationDTOResponse = new OrganisationDTOResponse();
            organisationDTOResponse.setName(savedorganisation.getName());
            organisationDTOResponse.setAddress(savedorganisation.getAddress());
            organisationDTOResponse.setPhoneNumber(savedorganisation.getPhoneNumber());
            organisationDTOResponse.setPhoneNumber(savedorganisation.getPhoneNumber());
            return organisationDTOResponse;
        } else {
            throw new RuntimeException("User not found with id " + id);
        }
    }
    @Override
    public void deleteOrganisation(Long id) {
        if (organisationRepo.existsById(id)) {
            organisationRepo.deleteById(id);
        } else {
            throw new RuntimeException("User not found with id " + id);
        }

    }
}

