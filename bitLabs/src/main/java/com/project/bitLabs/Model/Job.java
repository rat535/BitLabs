package com.project.bitLabs.Model;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.project.bitLabs.enums.Qualifaction;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Job {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long jobId;

	@NotBlank(message = "Please enter a valid job tittle")
	private String jobTitle;

	@NotBlank(message = "Please enter a valid salary range.")
	private String salaryRange;

	@NotBlank(message = "Please select a location.")
	private String location;

	@NotBlank(message = "Please select an employee type.")
	private String employeeType;

	@Enumerated(EnumType.STRING)
	private Qualifaction minimumQualification;

	private int minExpericence;

	@ElementCollection
	private Set<String> requiredSkills;

	@ManyToMany(mappedBy = "appliedJobs")
	@JsonIgnore
	private Set<User> users = new HashSet<>();

	public Job() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Job(Long jobId, @NotBlank(message = "Please enter a valid job tittle") String jobTitle,
			@NotBlank(message = "Please enter a valid salary range.") String salaryRange,
			@NotBlank(message = "Please select a location.") String location,
			@NotBlank(message = "Please select an employee type.") String employeeType,
			Qualifaction minimumQualification, int minExpericence, Set<String> requiredSkills, Set<User> users) {
		super();
		this.jobId = jobId;
		this.jobTitle = jobTitle;
		this.salaryRange = salaryRange;
		this.location = location;
		this.employeeType = employeeType;
		this.minimumQualification = minimumQualification;
		this.minExpericence = minExpericence;
		this.requiredSkills = requiredSkills;
		this.users = users;
	}

	public Long getJobId() {
		return jobId;
	}

	public void setJobId(Long jobId) {
		this.jobId = jobId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getSalaryRange() {
		return salaryRange;
	}

	public void setSalaryRange(String salaryRange) {
		this.salaryRange = salaryRange;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public Qualifaction getMinimumQualification() {
		return minimumQualification;
	}

	public void setMinimumQualification(Qualifaction minimumQualification) {
		this.minimumQualification = minimumQualification;
	}

	public Set<String> getRequiredSkills() {
		return requiredSkills;
	}

	public void setRequiredSkills(Set<String> requiredSkills) {
		this.requiredSkills = requiredSkills;
	}

	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public int getMinExpericence() {
		return minExpericence;
	}

	public void setMinExpericence(int minExpericence) {
		this.minExpericence = minExpericence;
	}

}
