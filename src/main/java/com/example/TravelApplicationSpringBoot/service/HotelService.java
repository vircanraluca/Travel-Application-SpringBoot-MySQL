package com.example.TravelApplicationSpringBoot.service;

import com.example.TravelApplicationSpringBoot.model.Hotel;
import com.example.TravelApplicationSpringBoot.repository.HotelRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelService {

    private final HotelRepository hotelRepository;

    public HotelService(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    public Hotel getById(Long id) {
        return hotelRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Hotelul cu id " + id + " nu exista!"));
    }
}