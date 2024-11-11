package com.project.bitLabs.Implment;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import com.project.bitLabs.Dto.JobDto;
import com.project.bitLabs.Dto.UserDto;
import com.project.bitLabs.Exception.CustomException;
import com.project.bitLabs.Model.Job;
import com.project.bitLabs.Model.User;
import com.project.bitLabs.Repository.JobRepo;
import com.project.bitLabs.Repository.UserRepo;
import com.project.bitLabs.enums.Skills;
import com.project.bitLabs.service.JobService;

@Service
public class JobServiceImpl implements JobService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private JobRepo jobrepo;
	
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
	
	
	//job DTo      To   job
	public Job dtoToJob(JobDto jobDto)
	{
		Job job = this.modelMapper.map(jobDto, Job.class);
		return job;
		
	}
	
	public JobDto JobToDto(Job job)
	{
		JobDto jobDto = this.modelMapper.map(job, JobDto.class);
		return jobDto;
	}
	
	
	@Override
	public boolean isUserQualifiedForJob(UserDto user, JobDto job) {

		if (user.getQualification().ordinal() < job.getMinimumQualification().ordinal()) {
			return false;
		}
		
		Set<Skills> userSkills = user.getSkills();
	    Set<String> jobSkills = job.getRequiredSkills();
	    
	    for (String skill : jobSkills) {
	        Skills requiredSkill = Skills.valueOf(skill);
	        if (!userSkills.contains(requiredSkill)) {
	            throw new IllegalArgumentException("User lacks the required skills for this job.");
	        }
	    }
	    
	    if(user.getTotalExperience()< job.getMinExpericence())return false;
	    
		return true;
	}
	public boolean applyForJob(Long userId, Long jobId) {
	  
	    User user = userRepo.findById(userId)
	            .orElseThrow(() -> new CustomException("User not found with id: " + userId));
	   
	    Job job = jobrepo.findById(jobId)
	            .orElseThrow(() -> new CustomException("Job not found with id: " + jobId));
	    
	    UserDto userDto = this.UserToDto(user);
	    JobDto jobDto = this.JobToDto(job);
	    
	    if (isUserQualifiedForJob(userDto, jobDto)) {
	    	
	    	user.getAppliedJobs().add(job);

	        // Add the user to the job's list of applicants
	        job.getUsers().add(user);

	        // Save the updated entities to the database
	        userRepo.save(user);  // Persist the updated user
	        jobrepo.save(job);    
	        return true; 
	    }
	    
	    return false; 
	}

	@Override
	public JobDto addJob(JobDto jobDto) {
		Job job = this.dtoToJob(jobDto);
		Job savedJob=this.jobrepo.save(job); 
		return this.JobToDto(savedJob);
	}

	@Override
	public JobDto getJobById(Long jobId) {
		 Job job = jobrepo.findById(jobId).orElseThrow(() -> new RuntimeException("Job not found with ID: " + jobId));
		 return this.JobToDto(job);
	}

	@Override
	public JobDto updateJob(Long jobId, JobDto updatedJob) {
		Job job = jobrepo.findById(jobId)
                .orElseThrow(() -> new RuntimeException("Job not found with ID: " + jobId));

        job.setJobTitle(updatedJob.getJobTitle());
        job.setMinExpericence(updatedJob.getMinExpericence());
        job.setSalaryRange(updatedJob.getSalaryRange());
        job.setLocation(updatedJob.getLocation());
        job.setEmployeeType(updatedJob.getEmployeeType());
        job.setMinimumQualification(updatedJob.getMinimumQualification());
        job.setRequiredSkills(updatedJob.getRequiredSkills());
        // Update other fields as needed
        jobrepo.save(job);

        return this.JobToDto(job);
        		
	}

	@Override
	public List<UserDto> getUsersByJobId(Long jobId) {
		Job job = jobrepo.findById(jobId)
	            .orElseThrow(() -> new CustomException("Job not found with id: " + jobId));
	        
	        // Convert each User to UserDto and collect in a list
	        return job.getUsers().stream().map((account) -> this.UserToDto(account)).collect(Collectors.toList());
	}

}
