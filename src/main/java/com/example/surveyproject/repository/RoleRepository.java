package com.example.surveyproject.repository;

import com.example.surveyproject.models.ERole;
import com.example.surveyproject.models.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}