package com.example.TravelApplicationSpringBoot.controller;

import com.example.TravelApplicationSpringBoot.model.Destination;
import com.example.TravelApplicationSpringBoot.service.DestinationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/destination")
public class DestinationController {

    private final DestinationService destinationService;

    public DestinationController(DestinationService destinationService) {
        this.destinationService = destinationService;
    }

    @GetMapping
    public List<Destination> getAllDestination() {
        return destinationService.getAllDestination();
    }

    @GetMapping("/{destinationId}")
    public Destination getDestinationDetails(@PathVariable String destinationId){
        return destinationService.getDestionation(destinationId);
    }

    @PostMapping
    public String createDestination(@RequestBody Destination destination){
       destinationService.createDestination(destination);
        return "Destination created succesfuly";
    }

    @PutMapping("/{destinationId}")
    public String updateDestinationDetails(@PathVariable String destinationId,
                                           @RequestBody Destination destination) {

        destination.setDestinationId(destinationId);
        destinationService.updateDestion(destination);
        return "Destination updated successfully";
    }

    @DeleteMapping("/{destinationId}")
    public String deleteDestinationDetails(@PathVariable String destinationId){
        destinationService.deleteDestination(destinationId);
        return "Destination deleted succesfully";
    }

}
