package org.example.organisationms.mappers;


import org.example.organisationms.dtos.OrganisationDTOResponse;
import org.example.organisationms.entities.Organisation;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class OrganisationMapper {
    public OrganisationDTOResponse fromOrganisation(Organisation organisation){
        OrganisationDTOResponse organisationDTOResponse = new OrganisationDTOResponse();
        BeanUtils.copyProperties(organisation,organisationDTOResponse);
        return organisationDTOResponse;
    }
}
