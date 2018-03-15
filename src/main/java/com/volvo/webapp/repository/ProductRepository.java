package com.volvo.webapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.volvo.webapp.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
}