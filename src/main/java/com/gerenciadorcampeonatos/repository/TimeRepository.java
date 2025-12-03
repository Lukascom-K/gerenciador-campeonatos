package com.gerenciadorcampeonatos.repository;

import com.gerenciadorcampeonatos.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeRepository extends JpaRepository<Time, Long> {
}
