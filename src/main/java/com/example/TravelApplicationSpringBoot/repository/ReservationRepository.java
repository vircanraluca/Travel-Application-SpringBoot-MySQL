package com.example.TravelApplicationSpringBoot.repository;

import com.example.TravelApplicationSpringBoot.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    // findAll() si findById() mostenite din JpaRepository - nimic extra
}