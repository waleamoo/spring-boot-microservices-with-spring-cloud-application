package com.techqwerty.organisationservice.service;

import com.techqwerty.organisationservice.dto.OrganisationDto;

public interface OrganisationService {
    OrganisationDto saveOrganisation(OrganisationDto organisationDto);
    OrganisationDto getOrganisationByCode(String organisationCode);
}
