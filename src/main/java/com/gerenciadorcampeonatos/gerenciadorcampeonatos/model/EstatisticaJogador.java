// Local: .../model/EstatisticaJogador.java

package com.gerenciadorcampeonatos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EstatisticaJogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String tipoEstatistica; // Ex: "GOL", "CARTAO_AMARELO", "ASSISTENCIA"

    private Integer valor; // Ex: número de gols ou cartões

    // Chave Estrangeira 1: Estatística está ligada a um Jogador
    @ManyToOne
    @JoinColumn(name = "jogador_id", nullable = false)
    private Jogador jogador;

    // Chave Estrangeira 2: Estatística ocorreu em uma Partida
    @ManyToOne
    @JoinColumn(name = "partida_id", nullable = false)
    private Partida partida;
}