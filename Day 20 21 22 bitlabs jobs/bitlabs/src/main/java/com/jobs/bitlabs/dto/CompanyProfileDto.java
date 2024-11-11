package com.jobs.bitlabs.dto;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.util.Objects;

@Entity
public class CompanyProfileDto {

    @Id
    private String companyId;

    @Lob
    private byte[] logo;
    
    private String companyName;

    private String recruiterName;
    
    @Embedded
    private String companyAddress;
    
    
    private Long CompanyNumber;

    // Constructors
    public CompanyProfileDto() {
    	super();
    	
    }

  

    // Getters and Setters
   
    // Equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyProfileDto that = (CompanyProfileDto) o;
        return Objects.equals(companyId, that.companyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId);
    }
}
