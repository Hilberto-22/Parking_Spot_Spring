package com.example.parkingspot.spring.services;

import org.springframework.stereotype.Service;
import com.example.parkingspot.spring.repository.ParkingSpotRepository;

@Service
public class ParkingSpotService {
    
    ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }
}
