package com.volvo.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volvo.webapp.entites.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
