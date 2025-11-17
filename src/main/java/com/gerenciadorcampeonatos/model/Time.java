// src/main/java/com/gerenciadorcampeonatos/model/Time.java

package com.gerenciadorcampeonatos.model;

import jakarta.persistence.*; // Importa todas as anotações do JPA
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.util.List; // Importa a classe List do Java

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String nome;

    private String cidade;

    // Relacionamento Um-para-Muitos com Jogador
    // Note: Jogador, Tecnico e InscricaoCampeonato ainda não existem, mas vamos criá-los!
    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    private List<Jogador> jogadores;

    // Relacionamento Um-para-Um com Tecnico
    @OneToOne(mappedBy = "time", cascade = CascadeType.ALL)
    private Tecnico tecnico;

    // Relacionamento Um-para-Muitos com InscricaoCampeonato
    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    private List<InscricaoCampeonato> inscricoes;
}