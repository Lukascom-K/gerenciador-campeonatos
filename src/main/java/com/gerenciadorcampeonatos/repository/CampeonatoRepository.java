package com.gerenciadorcampeonatos.repository;

import com.gerenciadorcampeonatos.model.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CampeonatoRepository extends JpaRepository<Campeonato, Long> {
}
