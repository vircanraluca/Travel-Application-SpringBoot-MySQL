package com.example.TravelApplicationSpringBoot.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 100)
    private String country;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(name="image_url", length = 500)
    private String imageUrl;

    @Column(name = "climate_info", columnDefinition = "TEXT")
    private String climateInfo;

    //O destinatie are mai multe hoteluri
    // mappedBy = numele câmpului din Hotel care face referință la Destination
    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Hotel> hotels=new ArrayList<>();

    //O destinatie apare in mai multe pachete
    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TouristPackage> packages=new ArrayList<>();

    public Destination(){

    }

    public Destination(Long id, String city, String country, String description, String imageUrl, String climateInfo) {
        Id = id;
        this.city = city;
        this.country = country;
        this.description = description;
        this.imageUrl = imageUrl;
        this.climateInfo = climateInfo;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public String getClimateInfo() {
        return climateInfo;
    }

    public void setClimateInfo(String climateInfo) {
        this.climateInfo = climateInfo;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    public List<TouristPackage> getPackages() {
        return packages;
    }

    public void setPackages(List<TouristPackage> packages) {
        this.packages = packages;
    }

    @Override
    public String toString() {
        return "Destination{" +
                "Id=" + Id +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", climateInfo='" + climateInfo + '\'' +
                ", hotels=" + hotels +
                ", packages=" + packages +
                '}';
    }
}