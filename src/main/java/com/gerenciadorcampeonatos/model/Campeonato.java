package com.gerenciadorcampeonatos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "campeonatos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Campeonato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer ano;

    private String status;

    @Column(name = "data_inicio")
    private LocalDate dataInicio;
}
