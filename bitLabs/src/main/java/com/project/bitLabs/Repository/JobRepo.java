package com.project.bitLabs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bitLabs.Model.Job;

public interface JobRepo extends JpaRepository<Job, Long>{

}
