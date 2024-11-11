package com.jobs.bitlabs.dto;

import java.sql.Date;
import java.util.Set;

import com.jobs.bitlabs.entity.CompanyJob;
import com.jobs.bitlabs.enums.PefferedLocation;
import com.jobs.bitlabs.enums.Qualifaction;
import com.jobs.bitlabs.enums.Skills;
import com.project.bitLabs.payloads.Address;

import jakarta.persistence.Embedded;

public class UserDto {

	private String name;

	private String email; // Non-editable

	private String whatsapp;

	private Qualifaction qualification;

	private String specialization;

	private int totalExperience;

	private Set<PefferedLocation> PreferdJobLocation;

	@Embedded
	private Address address;

	private Date dateOfBirth;

	private Set<Skills> skills;

	private String profileImage;

	private String resume;
	
	

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}



	public UserDto(String name, String email, String whatsapp, Qualifaction qualification, String specialization,
			int totalExperience, Set<PefferedLocation> preferdJobLocation, Address address, Date dateOfBirth,
			Set<Skills> skills, String profileImage, String resume, Set<CompanyJob> appliedJobs) {
		super();
		this.name = name;
		this.email = email;
		this.whatsapp = whatsapp;
		this.qualification = qualification;
		this.specialization = specialization;
		this.totalExperience = totalExperience;
		PreferdJobLocation = preferdJobLocation;
		this.address = address;
		this.dateOfBirth = dateOfBirth;
		this.skills = skills;
		this.profileImage = profileImage;
		this.resume = resume;
		
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWhatsapp() {
		return whatsapp;
	}

	public void setWhatsapp(String whatsapp) {
		this.whatsapp = whatsapp;
	}

	public int getTotalExperience() {
		return totalExperience;
	}

	public void setTotalExperience(int totalExperience) {
		this.totalExperience = totalExperience;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Set<Skills> getSkills() {
		return skills;
	}

	public void setSkills(Set<Skills> skills) {
		this.skills = skills;
	}

	public Set<PefferedLocation> getPreferdJobLocation() {
		return PreferdJobLocation;
	}

	public void setPreferdJobLocation(Set<PefferedLocation> preferdJobLocation) {
		this.PreferdJobLocation = preferdJobLocation;
	}

	public Qualifaction getQualification() {
		return qualification;
	}

	public void setQualification(Qualifaction qualification) {
		this.qualification = qualification;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}

	public String getResume() {
		return resume;
	}

	public void setResume(String resume) {
		this.resume = resume;
	}

}
