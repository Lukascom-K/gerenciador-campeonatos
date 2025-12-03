package com.gerenciadorcampeonatos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Table(name = "tecnicos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer idade;

    @OneToOne
    @JoinColumn(name = "time_id")
    private Time time;
}
