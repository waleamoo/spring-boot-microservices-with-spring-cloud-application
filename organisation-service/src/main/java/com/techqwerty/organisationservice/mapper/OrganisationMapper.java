package com.techqwerty.organisationservice.mapper;

import com.techqwerty.organisationservice.dto.OrganisationDto;
import com.techqwerty.organisationservice.entity.Organisation;

public class OrganisationMapper {
    
    public static OrganisationDto mapToOrganisationDto(Organisation organisation){
        OrganisationDto organisationDto = new OrganisationDto(
            organisation.getId(),
            organisation.getOrganisationName(),
            organisation.getOrganisationDescription(),
            organisation.getOrganisationCode(),
            organisation.getOrganisationCreatedDate()
        );
        return organisationDto;
    }

    public static Organisation mapToOrganisation(OrganisationDto organisationDto){
        Organisation organisation = new Organisation(
            organisationDto.getId(),
            organisationDto.getOrganisationName(),
            organisationDto.getOrganisationDescription(),
            organisationDto.getOrganisationCode(),
            organisationDto.getOrganisationCreatedDate()
        );
        return organisation;
    }
    
}
