package com.volvo.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volvo.webapp.entites.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Integer> {

}
