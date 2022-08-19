package com.example.parkingspot.spring.services;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        return parkingSpotRepository.existsByPlacaCarro(placaCarro);
    }

    public boolean existeNumeroVaga(String numeroVaga) {
        return parkingSpotRepository.existsByNumeroVaga(numeroVaga);
    }

    public boolean existeBlocoEApartamento(String bloco, String apartamento) {
        return parkingSpotRepository.existsByBlocoAndApartamento(bloco,apartamento);
    }

    public List<ParkingSpotModel> listarTodos() {
        return parkingSpotRepository.findAll();
    }

    public Optional<ParkingSpotModel> listarPorId(UUID id) {
        return parkingSpotRepository.findById(id);
    }

    @Transactional
    public void deletarDadosVaga(ParkingSpotModel parkingSpotModel) {
        parkingSpotRepository.delete(parkingSpotModel);
    }

    public ParkingSpotModel atualizar(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    
}
