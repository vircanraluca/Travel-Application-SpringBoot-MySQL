package com.example.TravelApplicationSpringBoot.service;

import com.example.TravelApplicationSpringBoot.model.TouristPackage;
import com.example.TravelApplicationSpringBoot.repository.TouristPackageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristPackageService {

    private final TouristPackageRepository touristPackageRepository;

    public TouristPackageService(TouristPackageRepository touristPackageRepository) {
        this.touristPackageRepository = touristPackageRepository;
    }

    public List<TouristPackage> getAll() {
        return touristPackageRepository.findAll();
    }

    public TouristPackage getById(Long id) {
        return touristPackageRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pachetul cu id " + id + " nu exista!"));
    }
}