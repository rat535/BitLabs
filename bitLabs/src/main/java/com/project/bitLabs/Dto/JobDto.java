package com.project.bitLabs.Dto;


import java.util.Set;

import com.project.bitLabs.Model.User;
import com.project.bitLabs.enums.Qualifaction;

public class JobDto {



	private String jobTitle;

	private String salaryRange;

	private String location;

	private String employeeType;

	private Qualifaction minimumQualification;

	private Set<String> requiredSkills;



	private int minExpericence;

	public JobDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobDto(String jobTitle, String salaryRange, String location, String employeeType,
			Qualifaction minimumQualification, Set<String> requiredSkills, Set<User> users, int minExpericence) {
		super();
		
		this.jobTitle = jobTitle;
		this.salaryRange = salaryRange;
		this.location = location;
		this.employeeType = employeeType;
		this.minimumQualification = minimumQualification;
		this.requiredSkills = requiredSkills;

		this.minExpericence = minExpericence;
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



	public int getMinExpericence() {
		return minExpericence;
	}

	public void setMinExpericence(int minExpericence) {
		this.minExpericence = minExpericence;
	}

}
