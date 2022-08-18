package com.example.parkingspot.spring.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.parkingspot.spring.models.ParkingSpotModel;

@Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID>{

    boolean existeByPlacaCarro(String placaCarro);

    boolean existeByNumeroVaga(String numeroVaga);

    boolean existeByApartamentoBloco(String apartamento, String bloco);
    
}
