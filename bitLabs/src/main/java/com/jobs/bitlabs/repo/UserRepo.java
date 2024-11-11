package com.jobs.bitlabs.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobs.bitlabs.entity.Users;

public interface UserRepo extends JpaRepository<Users, Long>{

}
