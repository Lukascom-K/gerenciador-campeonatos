// src/main/java/com/gerenciadorcampeonatos/repository/TimeRepository.java

package com.gerenciadorcampeonatos.repository;

import com.gerenciadorcampeonatos.gerenciadorcampeonatos.model.Time;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeRepository extends JpaRepository<Time, Long> {
}