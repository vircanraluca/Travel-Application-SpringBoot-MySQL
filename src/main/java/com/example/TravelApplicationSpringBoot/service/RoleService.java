package com.example.TravelApplicationSpringBoot.service;

import com.example.TravelApplicationSpringBoot.model.Role;
import com.example.TravelApplicationSpringBoot.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAll() {
        return roleRepository.findAll();
    }

    public Role getById(Long id) {
        return roleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Rolul cu id " + id + " nu exista!"));
    }
}