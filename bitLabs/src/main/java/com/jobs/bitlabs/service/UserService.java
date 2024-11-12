package com.jobs.bitlabs.service;

import java.util.List;

import com.jobs.bitlabs.dto.CompanyJobDto;
import com.jobs.bitlabs.dto.UserDto;
import com.jobs.bitlabs.enums.Qualifaction;

public interface UserService {

	UserDto  createUser(UserDto userSto);
	UserDto getUserById(Long id);
	boolean isValidSpecialization(Qualifaction qualification, String specialization);
	UserDto updateUser(Long id, UserDto userDto);
	
	List<CompanyJobDto> getRecommendedJobs(Long userId);
}
