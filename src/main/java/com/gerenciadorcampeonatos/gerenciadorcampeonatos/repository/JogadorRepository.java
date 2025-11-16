// Local: .../repository/JogadorRepository.java

package com.gerenciadorcampeonatos.repository;

import com.gerenciadorcampeonatos.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends JpaRepository<Jogador, Long> {
}