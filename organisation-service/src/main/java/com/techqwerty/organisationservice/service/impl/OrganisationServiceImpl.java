package com.techqwerty.organisationservice.service.impl;

import org.springframework.stereotype.Service;

import com.techqwerty.organisationservice.dto.OrganisationDto;
import com.techqwerty.organisationservice.entity.Organisation;
import com.techqwerty.organisationservice.mapper.OrganisationMapper;
import com.techqwerty.organisationservice.repository.OrganisationRepository;
import com.techqwerty.organisationservice.service.OrganisationService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class OrganisationServiceImpl implements OrganisationService {

    private OrganisationRepository organisationRepository;


    @Override
    public OrganisationDto saveOrganisation(OrganisationDto organisationDto) {
        Organisation organisation = OrganisationMapper.mapToOrganisation(organisationDto);
        Organisation savedOrganisation = organisationRepository.save(organisation);
        return OrganisationMapper.mapToOrganisationDto(savedOrganisation);
    }


    @Override
    public OrganisationDto getOrganisationByCode(String organisationCode) {
        Organisation organisation = organisationRepository.findByOrganisationCode(organisationCode);
        return OrganisationMapper.mapToOrganisationDto(organisation);
    }
    
}
