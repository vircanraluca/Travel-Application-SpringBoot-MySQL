package com.example.TravelApplicationSpringBoot.service;

import com.example.TravelApplicationSpringBoot.model.Review;
import com.example.TravelApplicationSpringBoot.repository.ReviewRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public ReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    public List<Review> getAll() {
        return reviewRepository.findAll();
    }

    public Review getById(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recenzia cu id " + id + " nu exista!"));
    }
}