package com.example.parkingspot.spring.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parkingspot.spring.models.ParkingSpotModel;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID>{

    boolean existsByPlacaCarro(String placaCarro);

    boolean existsByNumeroVaga(String numeroVaga);

    boolean existsByBlocoAndApartamento(String bloco, String apartamento);
    
}
