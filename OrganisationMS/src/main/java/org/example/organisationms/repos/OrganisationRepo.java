package org.example.organisationms.repos;


import org.example.organisationms.entities.Organisation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganisationRepo extends JpaRepository<Organisation,Long> {
}
