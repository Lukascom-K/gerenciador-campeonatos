// Local: .../model/Partida.java

package com.gerenciadorcampeonatos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Partida {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime dataHora;

    private Integer placarCasa;
    private Integer placarVisitante;
    private String local;

    // Chave Estrangeira 1: Partida pertence a Uma Fase
    @ManyToOne
    @JoinColumn(name = "fase_id", nullable = false)
    private Fase fase;

    // Chave Estrangeira 2: Time da Casa
    @ManyToOne
    @JoinColumn(name = "time_casa_id", nullable = false)
    private Time timeCasa;

    // Chave Estrangeira 3: Time Visitante
    @ManyToOne
    @JoinColumn(name = "time_visitante_id", nullable = false)
    private Time timeVisitante;

    // Relacionamento Um-para-Muitas com EstatisticaJogador
    @OneToMany(mappedBy = "partida", cascade = CascadeType.ALL)
    private List<EstatisticaJogador> estatisticas;
}