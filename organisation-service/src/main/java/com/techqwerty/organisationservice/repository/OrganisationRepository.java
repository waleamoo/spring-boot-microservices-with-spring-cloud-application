package com.techqwerty.organisationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techqwerty.organisationservice.entity.Organisation;

public interface OrganisationRepository extends JpaRepository<Organisation, Long> {
    Organisation findByOrganisationCode(String organisationCode);
}
