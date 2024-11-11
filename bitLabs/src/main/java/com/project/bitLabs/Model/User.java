package com.project.bitLabs.Model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.project.bitLabs.enums.PefferedLocation;
import com.project.bitLabs.enums.Qualifaction;
import com.project.bitLabs.enums.Skills;
import com.project.bitLabs.payloads.Address;

import jakarta.persistence.CascadeType;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String name;

	private String email; // Non-editable

	private String whatsapp;

	private Qualifaction qualification;

	private String specialization;

	private int totalExperience;

	// private ProfilePicture profilePicture;

	@ElementCollection
	@Enumerated(EnumType.STRING)
	private Set<PefferedLocation> PreferdJobLocation;

	@Embedded
	private Address address;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Date dateOfBirth;

	@ElementCollection
	@Enumerated(EnumType.STRING)
	private Set<Skills> skills;

	private String profileImage;

	private String resume;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
	    name = "user_job_applications",
	    joinColumns = @JoinColumn(name = "user_id"),
	    inverseJoinColumns =@JoinColumn(name = "job_id")
	)
	private Set<Job> appliedJobs = new HashSet<>();
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public User(Long id, String name, String email, String whatsapp, Qualifaction qualification, String specialization,
			int totalExperience, Set<PefferedLocation> preferdJobLocation, Address address, Date dateOfBirth,
			Set<Skills> skills, String profileImage, String resume, Set<Job> appliedJobs) {
		super();
		this.id = id;
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
		this.appliedJobs = appliedJobs;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<PefferedLocation> getPreferdJobLocation() {
		return PreferdJobLocation;
	}

	public void setPreferdJobLocation(Set<PefferedLocation> preferdJobLocation) {
		this.PreferdJobLocation = preferdJobLocation;
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


	public Set<Job> getAppliedJobs() {
		return appliedJobs;
	}


	public void setAppliedJobs(Set<Job> appliedJobs) {
		this.appliedJobs = appliedJobs;
	}

	
}
