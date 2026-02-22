package com.example.TravelApplicationSpringBoot.service;

import com.example.TravelApplicationSpringBoot.model.Destination;

import java.util.List;

public interface DestinationService {
    public String createDestination(Destination destination);
    public String updateDestion(Destination destination);
    public String deleteDestination(String destinationId);

    public Destination getDestionation(String destinationId);

    public List<Destination> getAllDestination();

}
