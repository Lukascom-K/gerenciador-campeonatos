package com.gerenciadorcampeonatos.repository;

import com.gerenciadorcampeonatos.model.Inscricao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InscricaoRepository extends JpaRepository<Inscricao, Long> {
}
