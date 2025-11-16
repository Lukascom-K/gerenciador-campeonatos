// Local: com.gerenciadorcampeonatos.gerenciadorcampeonatos.repository

package com.gerenciadorcampeonatos.repository;

import com.gerenciadorcampeonatos.model.Campeonato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CampeonatoRepository extends JpaRepository<Campeonato, Long> {

    // Método que o Spring gera automaticamente para buscar por nome
    Campeonato findByNome(String nome);
}