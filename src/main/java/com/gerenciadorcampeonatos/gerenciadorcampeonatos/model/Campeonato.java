// Local: com.gerenciadorcampeonatos.gerenciadorcampeonatos.model

package com.gerenciadorcampeonatos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    @Column(nullable = false)
    private Integer ano;

    private String status;

    private LocalDate dataInicio;

    // Relacionamentos One-to-Many (O JPA cuida disso)
    @OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
    private List<InscricaoCampeonato> inscricoes;

    @OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
    private List<Fase> fases;
}