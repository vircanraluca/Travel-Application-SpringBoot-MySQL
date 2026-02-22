package com.example.TravelApplicationSpringBoot.repository;

import com.example.TravelApplicationSpringBoot.model.Destination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DestinationRepository extends JpaRepository<Destination, String> {
}
