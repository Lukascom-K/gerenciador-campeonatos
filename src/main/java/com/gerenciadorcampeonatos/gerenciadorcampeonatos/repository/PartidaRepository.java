// Local: .../repository/PartidaRepository.java

package com.gerenciadorcampeonatos.repository;

import com.gerenciadorcampeonatos.model.Partida;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartidaRepository extends JpaRepository<Partida, Long> {
}