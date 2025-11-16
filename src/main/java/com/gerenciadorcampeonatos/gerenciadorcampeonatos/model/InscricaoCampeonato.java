// Local: .../model/InscricaoCampeonato.java

package com.gerenciadorcampeonatos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InscricaoCampeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataInscricao;

    // Chave Estrangeira 1: Liga a Inscrição a um Campeonato
    @ManyToOne
    @JoinColumn(name = "campeonato_id", nullable = false)
    private Campeonato campeonato;

    // Chave Estrangeira 2: Liga a Inscrição a um Time
    @ManyToOne
    @JoinColumn(name = "time_id", nullable = false)
    private Time time;
}