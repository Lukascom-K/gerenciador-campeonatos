package com.gerenciadorcampeonatos.repository;

import com.gerenciadorcampeonatos.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}
