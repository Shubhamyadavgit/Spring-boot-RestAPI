package com.jsp.springJpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.springJpa.entity.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
