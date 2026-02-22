package com.example.TravelApplicationSpringBoot.repository;

import com.example.TravelApplicationSpringBoot.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    // findAll() si findById() mostenite din JpaRepository - nimic extra
}