// Local: .../repository/TecnicoRepository.java

package com.gerenciadorcampeonatos.repository;

import com.gerenciadorcampeonatos.model.Tecnico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TecnicoRepository extends JpaRepository<Tecnico, Long> {
}