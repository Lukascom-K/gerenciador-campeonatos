package com.gerenciadorcampeonatos.repository;

import com.gerenciadorcampeonatos.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PartidaRepository extends JpaRepository<Partida, Long> {
}
