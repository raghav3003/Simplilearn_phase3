package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.project.model.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Integer>{
	List<ProductEntity> findByBrand(String name);
	List<ProductEntity> findBySeason(String name);
	List<ProductEntity> findByCategory(String name);
	List<ProductEntity> findByColor(String name);
}
