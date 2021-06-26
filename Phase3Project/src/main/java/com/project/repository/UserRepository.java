package com.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.model.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

}
