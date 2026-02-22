package com.example.TravelApplicationSpringBoot.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="destination")
public class Destination {

    @Id
    private String destinationId;
    private String airportName;
    private String destinationName;

    public Destination(){

    }

    public Destination(String destinationId, String airportName, String destinationName) {
        this.destinationId = destinationId;
        this.airportName = airportName;
        this.destinationName = destinationName;
    }

    public String getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(String destinationId) {
        this.destinationId = destinationId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "destinationId='" + destinationId + '\'' +
                ", airportName='" + airportName + '\'' +
                ", destinationName='" + destinationName + '\'' +
                '}';
    }
}
