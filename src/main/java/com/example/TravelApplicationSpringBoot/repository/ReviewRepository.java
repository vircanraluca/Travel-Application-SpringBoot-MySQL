package com.example.TravelApplicationSpringBoot.repository;

import com.example.TravelApplicationSpringBoot.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    // findAll() si findById() mostenite din JpaRepository - nimic extra
}