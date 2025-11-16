// Local: .../repository/InscricaoCampeonatoRepository.java

package com.gerenciadorcampeonatos.repository;

import com.gerenciadorcampeonatos.model.InscricaoCampeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InscricaoCampeonatoRepository extends JpaRepository<InscricaoCampeonato, Long> {
}