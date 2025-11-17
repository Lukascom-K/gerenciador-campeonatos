// src/main/java/com/gerenciadorcampeonatos/service/CampeonatoService.java

package com.gerenciadorcampeonatos.service;

import com.gerenciadorcampeonatos.model.Campeonato;
import com.gerenciadorcampeonatos.repository.CampeonatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service // Marca a classe como um componente de serviço Spring
public class CampeonatoService {

    // Injeção de Dependência: O Spring cria e gerencia o objeto Repository
    @Autowired
    private CampeonatoRepository campeonatoRepository;

    // 1. Método CREAT/UPDATE (Salvar)
    public Campeonato salvar(Campeonato campeonato) {
        // O método save() do JpaRepository serve tanto para criar quanto para atualizar.
        return campeonatoRepository.save(campeonato);
    }

    // 2. Método READ ALL (Listar Todos)
    public List<Campeonato> listarTodos() {
        return campeonatoRepository.findAll();
    }

    // 3. Método READ ONE (Buscar por ID)
    public Optional<Campeonato> buscarPorId(Long id) {
        // O Optional evita NullPointerException se o ID não for encontrado
        return campeonatoRepository.findById(id);
    }

    // 4. Método DELETE (Deletar)
    public void deletar(Long id) {
        campeonatoRepository.deleteById(id);
    }
}