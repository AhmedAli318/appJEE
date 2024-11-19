package org.example.organisationms.web;


import org.example.organisationms.entities.Organisation;
import org.example.organisationms.repos.OrganisationRepo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(produces = "application/xml")
public class OrganisationRestController{
    private OrganisationRepo organisationRepo;
    public OrganisationRestController(OrganisationRepo organisationRepo){

        this.organisationRepo = organisationRepo;
    }

    @GetMapping("/organisations")
    public List<Organisation> organisationList(){

        return organisationRepo.findAll();
    }

    @GetMapping("/organisations/{id}")
    public Organisation organisation(@PathVariable Long id){
        return organisationRepo.findById(id).orElseThrow(() -> new RuntimeException(String.format("L'organisation n'existe pas!",id)));
    }

    @PostMapping("/organisations/{id}")
    public Organisation saveOrganisation(@RequestBody Organisation organisation){
        return organisationRepo.save(organisation);
    }

    @PutMapping("/organisations/{id}")
    public Organisation updateOrganisation(@PathVariable Long id, @RequestBody Organisation organisation){
        Organisation organisationById = organisationRepo.findById(id).get();
        if(organisation.getName() !=null) organisationById.setName(organisation.getName());
        if(organisation.getAddress() !=null) organisationById.setAddress(organisation.getAddress());
        if(organisation.getPhoneNumber() !=null) organisationById.setPhoneNumber(organisation.getPhoneNumber());
        if(organisation.getEmail() !=null) organisationById.setEmail(organisation.getEmail());
        return organisationRepo.save(organisationById);
    }

    @DeleteMapping("/organisations/{id}")
    public void deleteOrganisation(@PathVariable Long id) {
        organisationRepo.deleteById(id);
    }
}
