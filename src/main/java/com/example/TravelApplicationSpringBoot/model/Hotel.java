package com.example.TravelApplicationSpringBoot.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="hotels")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(nullable = false)
    private int stars;

    @Column(length =255)
    private String address;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name="image_url", length = 500)
    private String imageUrl;

    //mai multe hoteluri pot fi la aceeasi destinatie
   @ManyToMany(fetch = FetchType.LAZY)
   @JoinColumn(name="destination_id",nullable = false)
   private Destination destination;

   //un hotel apare in mai multe pachete
    @OneToMany(mappedBy = "hotel", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TouristPackage> packages = new ArrayList<>();

    public Hotel(){

    }

    public Hotel(Long id, String name, int stars, String address, String description, String imageUrl, Destination destination) {
        this.id = id;
        this.name = name;
        this.stars = stars;
        this.address = address;
        this.description = description;
        this.imageUrl = imageUrl;
        this.destination = destination;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStars() {
        return stars;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public List<TouristPackage> getPackages() {
        return packages;
    }

    public void setPackages(List<TouristPackage> packages) {
        this.packages = packages;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stars=" + stars +
                ", address='" + address + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", destination=" + destination +
                ", packages=" + packages +
                '}';
    }
}
