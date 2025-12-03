package com.gerenciadorcampeonatos.service;

import com.gerenciadorcampeonatos.model.Campeonato;
import com.gerenciadorcampeonatos.repository.CampeonatoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CampeonatoService {

    private final CampeonatoRepository repo;

    public CampeonatoService(CampeonatoRepository repo) {
        this.repo = repo;
    }

    public List<Campeonato> listarTodos() {
        return repo.findAll();
    }

    public Campeonato buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Campeonato não encontrado"));
    }

    public Campeonato salvar(Campeonato c) {
        return repo.save(c);
    }

    public Campeonato atualizar(Long id, Campeonato c) {
        Campeonato existente = buscarPorId(id);
        c.setId(existente.getId());
        return repo.save(c);
    }

    public void deletar(Long id) {
        Campeonato existente = buscarPorId(id);
        repo.delete(existente);
    }
}
