package com.project.bitLabs.Implment;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.project.bitLabs.Dto.UserDto;
import com.project.bitLabs.Exception.CustomException;
import com.project.bitLabs.Model.User;
import com.project.bitLabs.Repository.UserRepo;
import com.project.bitLabs.enums.BTechSpecialization;
import com.project.bitLabs.enums.DegreeSpecialization;
import com.project.bitLabs.enums.DiplomaSpecialization;
import com.project.bitLabs.enums.IntermediateSpecialization;
import com.project.bitLabs.enums.MCASpecialization;
import com.project.bitLabs.enums.Qualifaction;
import com.project.bitLabs.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	public User dtoToUser(UserDto userDto)
	{
		User user = this.modelMapper.map(userDto, User.class);
		return user;
		
	}
	public UserDto UserToDto(User user)
	{
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}
	
	
	@Override
	public UserDto createUser(UserDto userDto) {
		User user = this.dtoToUser(userDto);
		User savedUser=this.userRepo.save(user); 
		return this.UserToDto(savedUser);
	}
	@Override
	public UserDto getUserById(Long userId) {
		
		User user = this.userRepo.findById(userId).orElseThrow(() -> new CustomException("User not found with id: " + userId));
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
		User user = this.userRepo.findById(userId).orElseThrow(() -> new CustomException("User not found with id: " + userId));
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
