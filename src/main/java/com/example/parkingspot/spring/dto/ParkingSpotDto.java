package com.example.parkingspot.spring.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class ParkingSpotDto {
    
    @NotBlank
    private String numeroVaga;
    @NotBlank
    @Size(max = 7)
    private String placaCarro;
    @NotBlank
    private String marcaCarro;
    @NotBlank
    private String modeloCarro;
    @NotBlank
    private String corCarro;
    @NotBlank
    private String nomeResponsavel;
    @NotBlank
    private String apartamento;
    @NotBlank
    private String bloco;  
    
}
