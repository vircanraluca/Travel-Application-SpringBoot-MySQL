package com.example.TravelApplicationSpringBoot.service.impl;

import com.example.TravelApplicationSpringBoot.model.Destination;
import com.example.TravelApplicationSpringBoot.repository.DestinationRepository;
import com.example.TravelApplicationSpringBoot.service.DestinationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationServiceImplementation implements DestinationService {

    DestinationRepository destinationRepository;

    public DestinationServiceImplementation(DestinationRepository destinationRepository) {
        this.destinationRepository = destinationRepository;
    }

    @Override
    public String createDestination(Destination destination) {
       destinationRepository.save(destination);
       return "Succes";
    }

    @Override
    public String updateDestion(Destination destination) {
        destinationRepository.save(destination);
        return "Succes";
    }

    @Override
    public String deleteDestination(String destinationId) {

        destinationRepository.deleteById(destinationId);
        return "Succes";
    }

    @Override
    public Destination getDestionation(String destinationId) {
        return destinationRepository.findById(destinationId).get();
    }

    @Override
    public List<Destination> getAllDestination() {
        return destinationRepository.findAll();
    }
}
