package com.example.TravelApplicationSpringBoot.controller;

import com.example.TravelApplicationSpringBoot.model.Destination;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/destination")
public class DestinationController {

    Destination destination;

    @GetMapping("/{destinationId}")
    public Destination getDestinationDetails(@PathVariable String destinationId){
        return destination;
    }

    @PostMapping
    public String createDestination(@RequestBody Destination destination){
        this.destination=destination;
        return "Destination created succesfuly";
    }

    @PutMapping
    public String updateDestinationDetails(@RequestBody Destination destination){
        this.destination=destination;
        return "Destination updated succesfuly";
    }

    @DeleteMapping
    public String deleteDestinationDetails(String destinationId){
        this.destination=null;
        return "Destination deleted succesfully";
    }

}
