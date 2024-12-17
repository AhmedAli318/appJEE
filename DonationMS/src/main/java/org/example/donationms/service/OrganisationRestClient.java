package org.example.donationms.service;

import org.example.donationms.models.Organisation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="ORGANISATIONMS")
public interface OrganisationRestClient {
    @GetMapping(path="/organisations")
    PagedModel<Organisation> pageOrganisation(@RequestParam(value="page") int page,
                                              @RequestParam(value="taille")int taille);
    @GetMapping(path="/organisations/{id}")
    Organisation getOrganisationById(@PathVariable Long id);
}
