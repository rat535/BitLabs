package com.jobs.bitlabs.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.bitlabs.dto.UserDto;
import com.jobs.bitlabs.entity.Users;
import com.jobs.bitlabs.enums.BTechSpecialization;
import com.jobs.bitlabs.enums.DegreeSpecialization;
import com.jobs.bitlabs.enums.DiplomaSpecialization;
import com.jobs.bitlabs.enums.IntermediateSpecialization;
import com.jobs.bitlabs.enums.MCASpecialization;
import com.jobs.bitlabs.enums.Qualifaction;
import com.jobs.bitlabs.exception.CustomException;
import com.jobs.bitlabs.repo.UserRepo;

@Service
public class UserServieceImpl implements UserService{


	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public Users dtoToUser(UserDto userDto)
	{
		Users user = this.modelMapper.map(userDto, Users.class);
		return user;
		
	}
	public UserDto UserToDto(Users user)
	{
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		Users user = this.dtoToUser(userDto);
		Users savedUser=this.userRepo.save(user); 
		return this.UserToDto(savedUser);
	}
	@Override
	public UserDto getUserById(Long userId) {
		
		Users user = this.userRepo.findById(userId).orElseThrow(() -> new CustomException("User not found with id: " + userId));
		return this.UserToDto(user);
	}
	
	
	@Override
	public boolean isValidSpecialization(Qualifaction qualification, String specialization) {
		switch (qualification) {
        case BTECH:
            return BTechSpecialization.valueOf(specialization) != null;
        case MCA:
            return MCASpecialization.valueOf(specialization) != null;
        case DEGREE:
            return DegreeSpecialization.valueOf(specialization) != null;
        case INTERMEDIATE:
            return IntermediateSpecialization.valueOf(specialization) != null;
        case DIPLOMA:
            return DiplomaSpecialization.valueOf(specialization) != null;
        default:
            return false;
    }
	}
	@Override
	public UserDto updateUser(Long userId, UserDto userDto) {
		// TODO Auto-generated method stub
		Users user = this.userRepo.findById(userId).orElseThrow(() -> new CustomException("User not found with id: " + userId));
        user.setPreferdJobLocation(userDto.getPreferdJobLocation());
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setWhatsapp(userDto.getWhatsapp());
        user.setQualification(userDto.getQualification());
        user.setSpecialization(userDto.getSpecialization());
       
        user.setTotalExperience(userDto.getTotalExperience());
        user.setSkills(userDto.getSkills());
        user.setAddress(userDto.getAddress());
        user.setDateOfBirth(userDto.getDateOfBirth());
        user.setProfileImage(userDto.getProfileImage());
        user.setResume(userDto.getResume());
        
		userRepo.save(user);
		
		return this.UserToDto(user);
	}

}
