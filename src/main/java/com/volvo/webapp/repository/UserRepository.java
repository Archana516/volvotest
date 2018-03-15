package com.volvo.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volvo.webapp.entites.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
