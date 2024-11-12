package com.jobs.bitlabs.service;

import com.jobs.bitlabs.dto.UserDto;
import com.jobs.bitlabs.enums.Qualifaction;

public interface UserService {

	UserDto  createUser(UserDto userSto);
	UserDto getUserById(Long id);
	boolean isValidSpecialization(Qualifaction qualification, String specialization);
	UserDto updateUser(Long id, UserDto userDto);
}
