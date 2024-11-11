package com.project.bitLabs.service;


import com.project.bitLabs.Dto.UserDto;
import com.project.bitLabs.enums.Qualifaction;



public interface UserService {
	 
	UserDto createUser(UserDto userSto);
	UserDto getUserById(Long id);
	boolean isValidSpecialization(Qualifaction qualification, String specialization);
	UserDto updateUser(Long id, UserDto userDto);
}
