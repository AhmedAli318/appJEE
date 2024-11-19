package org.example.organisationms.services;



import org.example.organisationms.dtos.OrganisationDTORequest;
import org.example.organisationms.dtos.OrganisationDTOResponse;
import org.example.organisationms.entities.Organisation;

import java.util.List;

public interface OrganisationService {
    List<Organisation> findOrganisations();
    OrganisationDTOResponse addOrganisation(OrganisationDTORequest organisationDTORequest);
    OrganisationDTOResponse updateOrganisation(Long id, OrganisationDTORequest organisationDTORequest);
    void deleteOrganisation(Long id);
}
