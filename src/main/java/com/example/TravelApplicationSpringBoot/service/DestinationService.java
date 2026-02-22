package com.example.TravelApplicationSpringBoot.service;

import com.example.TravelApplicationSpringBoot.model.Destination;
import com.example.TravelApplicationSpringBoot.repository.DestinationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationService {

    private final DestinationRepository destinationRepository;

    public DestinationService(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    public List<Destination> getAll() {
        return destinationRepository.findAll();
    }

    public Destination getById(Long id) {
        return destinationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Destinatia cu id " + id + " nu exista!"));
    }
}
