// Local: .../model/Jogador.java

package com.gerenciadorcampeonatos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private Integer numeroCamisa;

    // Relacionamento ManyToOne com Time
    @ManyToOne
    @JoinColumn(name = "time_id", nullable = false)
    private Time time;

    // Relacionamento OneToMany com EstatisticaJogador
    @OneToMany(mappedBy = "jogador", cascade = CascadeType.ALL)
    private List<EstatisticaJogador> estatisticas;
}