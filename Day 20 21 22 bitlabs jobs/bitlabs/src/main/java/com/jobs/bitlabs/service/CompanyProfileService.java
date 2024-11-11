package com.jobs.bitlabs.service;




import com.jobs.bitlabs.entity.CompanyProfile;

import java.util.Optional;

public interface CompanyProfileService  {



 

   CompanyProfile saveCompanyProfile(CompanyProfile companyProfile) ;

    Optional<CompanyProfile> getCompanyProfileById(String companyId) ;

    public void deleteCompanyProfile(String companyId);
}
