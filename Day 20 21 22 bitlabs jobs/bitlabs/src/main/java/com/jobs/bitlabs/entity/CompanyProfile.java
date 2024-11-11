package com.jobs.bitlabs.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

import java.util.Objects;

@Entity
public class CompanyProfile {

    @Id
    private String companyId;

    @Lob
    private byte[] logo;
    
    private String companyName;

    private String recruiterName;
    
    @Embedded
    private String companyAddress;
    
    
    private Long companyNumber;

    // Constructors
    public CompanyProfile() {
    	super();
    	
    }

  

    // Getters and Setters
   
    // Equals and hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyProfile that = (CompanyProfile) o;
        return Objects.equals(companyId, that.companyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId);
    }
}
