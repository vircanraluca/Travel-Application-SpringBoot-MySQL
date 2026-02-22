package com.example.TravelApplicationSpringBoot.repository;

import com.example.TravelApplicationSpringBoot.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Long> {
    // findAll() si findById() mostenite din JpaRepository - nimic extra
}