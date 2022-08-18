package com.example.parkingspot.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.example.parkingspot.spring.models.ParkingSpotModel;
import com.example.parkingspot.spring.repository.ParkingSpotRepository;

@Service
public class ParkingSpotService {
   
    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public ParkingSpotModel salvarVaga(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    public boolean existePlacaCarro(String placaCarro) {
        return parkingSpotRepository.existeByPlacaCarro(placaCarro);
    }

    public boolean existeNumeroVaga(String numeroVaga) {
        return parkingSpotRepository.existeByNumeroVaga(numeroVaga);
    }

    public boolean existeBlocoEApartamento(String apartamento, String bloco) {
        return parkingSpotRepository.existeByApartamentoBloco(apartamento, bloco);
    }

    public List<ParkingSpotModel> listarTodos() {
        return parkingSpotRepository.findAll();
    }

    
}
