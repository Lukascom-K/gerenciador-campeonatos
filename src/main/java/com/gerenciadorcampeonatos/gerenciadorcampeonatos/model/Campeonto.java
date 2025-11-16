// src/main/java/com/gerenciadorcampeonatos/model/Campeonato.java

package com.gerenciadorcampeonatos.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import java.time.LocalDate;

@Entity // Indica que esta classe é uma tabela no banco de dados
@Data // Gera Getters, Setters, toString, equals e hashCode (Lombok)
@NoArgsConstructor // Gera construtor sem argumentos (Lombok)
@AllArgsConstructor // Gera construtor com todos os argumentos (Lombok)
public class Campeonato {

    @Id // Indica que é a chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Configura a chave para ser auto-incremento
    private Long id;

    @Column(nullable = false, unique = true) // O nome não pode ser nulo e deve ser único
    private String nome;

    @Column(nullable = false)
    private Integer ano;

    private String status; // Ex: "EM_ANDAMENTO", "FINALIZADO"

    private LocalDate dataInicio;

    // Relacionamento Um-para-Muitos com InscricaoCampeonato (um campeonato tem muitas inscrições)
    // O 'mappedBy' indica que o campo 'campeonato' na classe InscricaoCampeonato é responsável pelo mapeamento
    @OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
    private List<InscricaoCampeonato> inscricoes;

    // Relacionamento Um-para-Muitos com Fase (um campeonato tem muitas fases)
    @OneToMany(mappedBy = "campeonato", cascade = CascadeType.ALL)
    private List<Fase> fases;
}