// Local: .../model/Fase.java

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
public class Fase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome; // Ex: Fase de Grupos, Final

    // Chave Estrangeira: Muitas Fases pertencem a Um Campeonato
    @ManyToOne
    @JoinColumn(name = "campeonato_id", nullable = false)
    private Campeonato campeonato;

    // Relacionamento Um-para-Muitas: Uma Fase tem Muitas Partidas
    @OneToMany(mappedBy = "fase", cascade = CascadeType.ALL)
    private List<Partida> partidas;
}