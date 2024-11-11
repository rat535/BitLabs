package com.project.bitLabs.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.bitLabs.Model.User;

public interface UserRepo extends JpaRepository<User, Long> {

}
