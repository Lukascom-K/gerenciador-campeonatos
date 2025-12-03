package com.gerenciadorcampeonatos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "partidas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_partida")
    private LocalDateTime dataPartida;

    @ManyToOne
    @JoinColumn(name = "fase_id")
    private Fase fase;

    @ManyToOne
    @JoinColumn(name = "time_casa_id")
    private Time timeCasa;

    @ManyToOne
    @JoinColumn(name = "time_visitante_id")
    private Time timeVisitante;

    private Integer golsCasa;
    private Integer golsVisitante;
}
