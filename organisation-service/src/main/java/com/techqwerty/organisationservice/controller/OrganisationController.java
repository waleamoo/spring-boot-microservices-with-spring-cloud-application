package com.techqwerty.organisationservice.controller;

import org.springframework.web.bind.annotation.RestController;

import com.techqwerty.organisationservice.dto.OrganisationDto;
import com.techqwerty.organisationservice.service.OrganisationService;

import lombok.AllArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("api/organisation")
@AllArgsConstructor
public class OrganisationController {
    
    private OrganisationService organisationService;

    @PostMapping
    public ResponseEntity<OrganisationDto> saveOrganisation(@RequestBody OrganisationDto organisationDto) {
        OrganisationDto savedOgOrganisationDto = organisationService.saveOrganisation(organisationDto);
        return new ResponseEntity<>(savedOgOrganisationDto, HttpStatus.CREATED);
    }

    @GetMapping("{code}")
    public ResponseEntity<OrganisationDto> getMethodName(@PathVariable("code") String organisationCode) {
        OrganisationDto organisationDto = organisationService.getOrganisationByCode(organisationCode);
        return ResponseEntity.ok(organisationDto);
    }
    
    
}
