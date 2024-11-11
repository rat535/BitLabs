package com.jobs.bitlabs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.bitlabs.repo.CompanyProfileRepository;
import com.jobs.bitlabs.entity.CompanyProfile;

import java.util.Optional;

@Service
public class CompanyProfileServiceImpl  {

    private final CompanyProfileRepository companyProfileRepository;

    @Autowired
    public CompanyProfileServiceImpl(CompanyProfileRepository companyProfileRepository) {
        this.companyProfileRepository = companyProfileRepository;
    }

    public CompanyProfile saveCompanyProfile(CompanyProfile companyProfile) {
        return companyProfileRepository.save(companyProfile);
    }

    public Optional<CompanyProfile> getCompanyProfileById(String companyId) {
        return companyProfileRepository.findById(companyId);
    }

    public void deleteCompanyProfile(String companyId) {
        companyProfileRepository.deleteById(companyId);
    }
}