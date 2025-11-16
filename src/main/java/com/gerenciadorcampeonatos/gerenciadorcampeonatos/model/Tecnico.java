// Local: .../model/Tecnico.java

package com.gerenciadorcampeonatos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tecnico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private Integer idade;

    // Relacionamento OneToOne com Time
    @OneToOne
    @JoinColumn(name = "time_id", nullable = false, unique = true)
    private Time time;
}