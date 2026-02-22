package com.example.TravelApplicationSpringBoot.repository;

import com.example.TravelApplicationSpringBoot.model.TouristPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TouristPackageRepository extends JpaRepository<TouristPackage, Long> {
    // findAll() si findById() mostenite din JpaRepository - nimic extra
}