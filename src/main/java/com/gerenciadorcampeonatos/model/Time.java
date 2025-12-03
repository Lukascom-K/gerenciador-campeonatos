package com.gerenciadorcampeonatos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Entity
@Table(name = "times")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Time {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cidade;

    @OneToMany(mappedBy = "time", cascade = CascadeType.ALL)
    private List<Jogador> jogadores;

    @OneToOne(mappedBy = "time", cascade = CascadeType.ALL)
    private Tecnico tecnico;
}
