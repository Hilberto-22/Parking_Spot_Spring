package com.example.parkingspot.spring.models;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "TB_PARKING_SPOT")
@Data
public class ParkingSpotModel implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    @Column(nullable = false, unique = true, length = 10)
    private String numeroVaga;

    @Column(nullable = false, unique = true, length = 7)
    private String placaCarro;

    @Column(nullable = false, length = 70)
    private String marcaCarro;

    @Column(nullable = false, length = 70)
    private String modeloCarro;

    @Column(nullable = false, length = 70)
    private String corCarro;

    @Column(nullable = false)
    private LocalDateTime dataRegistro;

    @Column(nullable = false, length = 130)
    private String nomeResponsavel;

    @Column(nullable = false, length = 30)
    private String apartamento;

    @Column(nullable = false, length = 30)
    private String bloco;

}
