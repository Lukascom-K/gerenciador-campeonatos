package com.gerenciadorcampeonatos.repository;

import com.gerenciadorcampeonatos.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
}
