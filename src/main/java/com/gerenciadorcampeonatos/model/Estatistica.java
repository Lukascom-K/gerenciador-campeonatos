package com.gerenciadorcampeonatos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "estatisticas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Estatistica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipo;
    private Integer valor;

    @ManyToOne
    @JoinColumn(name = "jogador_id")
    private Jogador jogador;

    @ManyToOne
    @JoinColumn(name = "partida_id")
    private Partida partida;
}
