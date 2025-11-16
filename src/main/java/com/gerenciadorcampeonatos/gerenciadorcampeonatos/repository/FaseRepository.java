// Local: .../repository/FaseRepository.java

package com.gerenciadorcampeonatos.repository;

import com.gerenciadorcampeonatos.model.Fase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FaseRepository extends JpaRepository<Fase, Long> {
}