package com.jobs.bitlabs.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jobs.bitlabs.dto.CompanyJobDto;
import com.jobs.bitlabs.dto.UserDto;
import com.jobs.bitlabs.entity.CompanyJob;
import com.jobs.bitlabs.entity.Users;
import com.jobs.bitlabs.enums.BTechSpecialization;
import com.jobs.bitlabs.enums.DegreeSpecialization;
import com.jobs.bitlabs.enums.DiplomaSpecialization;
import com.jobs.bitlabs.enums.IntermediateSpecialization;
import com.jobs.bitlabs.enums.MCASpecialization;
import com.jobs.bitlabs.enums.Qualifaction;
import com.jobs.bitlabs.exception.CustomException;
import com.jobs.bitlabs.repo.CompanyJobRepo;
import com.jobs.bitlabs.repo.UserRepo;

@Service
public class UserServieceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private CompanyJobRepo companyJobRepo;
	
	
	

	public Users dtoToUser(UserDto userDto) {
		Users user = this.modelMapper.map(userDto, Users.class);
		return user;

	}

	public UserDto UserToDto(Users user) {
		UserDto userDto = this.modelMapper.map(user, UserDto.class);
		return userDto;
	}
	
	

	public CompanyJob dtoToJob(CompanyJobDto jobDto) {
		CompanyJob job = this.modelMapper.map(jobDto, CompanyJob.class);
		return job;

	}

	public CompanyJobDto JobToDto(CompanyJob job) {
		CompanyJobDto jobDto = this.modelMapper.map(job, CompanyJobDto.class);
		return jobDto;
	}

	@Override
	public UserDto createUser(UserDto userDto) {
		Users user = this.dtoToUser(userDto);
		Users savedUser = this.userRepo.save(user);
		return this.UserToDto(savedUser);
	}

	@Override
	public UserDto getUserById(Long userId) {

		Users user = this.userRepo.findById(userId)
				.orElseThrow(() -> new CustomException("User not found with id: " + userId));
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
		Users user = this.userRepo.findById(userId)
				.orElseThrow(() -> new CustomException("User not found with id: " + userId));
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

	@Override
	public List<CompanyJobDto> getRecommendedJobs(Long userId) {
		Users user = this.userRepo.findById(userId)
				.orElseThrow(() -> new CustomException("User not found with id: " + userId));
		List<CompanyJob> recommendedJobs = companyJobRepo.findAll().stream()
				.filter(job -> matchesUserProfile(user, job)).collect(Collectors.toList());
		return recommendedJobs.stream().map(this::JobToDto).collect(Collectors.toList());
	}

	private boolean matchesUserProfile(Users user, CompanyJob job) {
	    // Checking if the user's qualification matches the job's qualification
		boolean matchesQualification = user.getQualification() != null 
                && user.getQualification().toString().equalsIgnoreCase(job.getQualification());


	    // Checking if the user's experience matches the job's experience range
	    boolean matchesExperience = user.getTotalExperience() >= job.getExperienceMin()
	            && user.getTotalExperience() <= job.getExperienceMax();

	    // Convert user skills (Set<Skills>) to List<String> for comparison with job's skills (List<String>)
	    List<String> userSkills = user.getSkills().stream()
	            .map(Enum::name) 
	            .collect(Collectors.toList());

	    // Checking if the user's skills match the job's required skills
	    boolean matchesSkills = userSkills.containsAll(job.getSkills());

	    // Checking if the user's preferred job location contains the job's location

	    boolean matchesLocation = user.getPreferdJobLocation() != null &&
	                              job.getLocation() != null &&
	                              user.getPreferdJobLocation().stream()
	                                  .map(Enum::name) 
	                                  .anyMatch(job.getLocation()::equalsIgnoreCase);

	    // Return true if all criteria match
	    return matchesQualification && matchesExperience && matchesSkills && matchesLocation;
	}



}
