package com.gerenciadorcampeonatos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "jogadores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Jogador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer numeroCamisa;

    @ManyToOne
    @JoinColumn(name = "time_id")
    private Time time;
}
