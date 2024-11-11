package com.project.bitLabs.service;

import java.util.List;

import com.project.bitLabs.Dto.JobDto;
import com.project.bitLabs.Dto.UserDto;

public interface JobService {

	boolean isUserQualifiedForJob(UserDto user, JobDto job);

	boolean applyForJob(Long userId, Long jobId);

	JobDto addJob(JobDto jobDto);

	JobDto getJobById(Long jobId);
	
	JobDto updateJob(Long jobId, JobDto updatedJob);
	
	List<UserDto> getUsersByJobId(Long jobId);

}
