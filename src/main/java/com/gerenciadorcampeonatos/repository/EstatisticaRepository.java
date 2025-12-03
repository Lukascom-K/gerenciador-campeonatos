package com.gerenciadorcampeonatos.repository;

import com.gerenciadorcampeonatos.model.Estatistica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstatisticaRepository extends JpaRepository<Estatistica, Long> {
}
