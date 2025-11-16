// Local: .../repository/EstatisticaJogadorRepository.java

package com.gerenciadorcampeonatos.repository;

import com.gerenciadorcampeonatos.model.EstatisticaJogador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstatisticaJogadorRepository extends JpaRepository<EstatisticaJogador, Long> {
}