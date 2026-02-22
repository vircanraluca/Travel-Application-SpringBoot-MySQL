package com.example.TravelApplicationSpringBoot.service;

import com.example.TravelApplicationSpringBoot.model.User;
import com.example.TravelApplicationSpringBoot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public User getById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Userul cu id " + id + " nu exista!"));
    }
}
