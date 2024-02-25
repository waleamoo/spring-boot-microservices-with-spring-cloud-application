package com.techqwerty.employeeservice.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrganisationDto {
    private Long id; 
    private String organisationName;
    private String organisationDescription;
    private String organisationCode;
    private LocalDateTime organisationCreatedDate;
}
