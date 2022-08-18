package com.example.parkingspot.spring.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.parkingspot.spring.dto.ParkingSpotDto;
import com.example.parkingspot.spring.models.ParkingSpotModel;
import com.example.parkingspot.spring.services.ParkingSpotService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/parking-spot")
public class ParkingSpotController {
    
    final ParkingSpotService parkingSpotService;

    public ParkingSpotController(ParkingSpotService parkingSpotService) {
        this.parkingSpotService = parkingSpotService;
    }

    @PostMapping("/salvarNovaVaga")
    public ResponseEntity<Object> saveParkingSpot(@RequestBody @Valid ParkingSpotDto parkingSpotDto){
        if(parkingSpotService.existePlacaCarro(parkingSpotDto.getPlacaCarro())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Placa de carro já esta cadastrada");
        }
        if(parkingSpotService.existeNumeroVaga(parkingSpotDto.getNumeroVaga())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Numero da vaga já esta em uso.");
        }
        if(parkingSpotService.existeBlocoEApartamento(parkingSpotDto.getApartamento(), parkingSpotDto.getBloco())){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Numero de vaga já esta sendo utilizad por outro apartamento");
        }
        ParkingSpotModel parkingSpotModel = new ParkingSpotModel();
        BeanUtils.copyProperties(parkingSpotDto, parkingSpotModel);
        parkingSpotModel.setDataRegistro(LocalDateTime.now(ZoneId.of("UTC")));
        return ResponseEntity.status(HttpStatus.CREATED).body(parkingSpotService.salvarVaga(parkingSpotModel));
    }
    @GetMapping("/listarTodos")
    public ResponseEntity<List<ParkingSpotModel>> getAllParkingSpots(){
        return ResponseEntity.status(HttpStatus.OK).body(parkingSpotService.listarTodos());
    }

}
 