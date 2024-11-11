package com.jobs.bitlabs.controller;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.jobs.bitlabs.entity.CompanyProfile;
import com.jobs.bitlabs.service.CompanyProfileService;
import java.io.IOException;

@RestController
@RequestMapping("/api/company-profiles")
public class CompanyProfileController {

    private final CompanyProfileService companyProfileService;

    @Autowired
    public CompanyProfileController(CompanyProfileService companyProfileService) {
        this.companyProfileService = companyProfileService;
    }

    @Operation(summary = "Create a new Company Profile")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Company Profile created",
                    content = @Content(schema = @Schema(implementation = CompanyProfile.class))),
            @ApiResponse(responseCode = "500", description = "Internal server error")
    })
    @PostMapping(consumes = {"multipart/form-data"})
    public ResponseEntity<CompanyProfile> createCompanyProfile(
            @RequestParam String companyId,
            @RequestParam String recruiterName,
            @RequestParam("logo") MultipartFile logo) { // No need to use @Parameter here for Swagger to recognize as file

        try {
            CompanyProfile companyProfile = new CompanyProfile(companyId, logo.getBytes(), recruiterName);
            CompanyProfile savedProfile = companyProfileService.saveCompanyProfile(companyProfile);
            return new ResponseEntity<>(savedProfile, HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
