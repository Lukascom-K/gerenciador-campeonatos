package com.gerenciadorcampeonatos.service;

import com.gerenciadorcampeonatos.model.Partida;
import com.gerenciadorcampeonatos.repository.PartidaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PartidaService {

    private final PartidaRepository repo;

    public PartidaService(PartidaRepository repo) {
        this.repo = repo;
    }

    public List<Partida> listarTodos() {
        return repo.findAll();
    }

    public Partida buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Partida não encontrada"));
    }

    public Partida salvar(Partida p) {
        return repo.save(p);
    }

    public Partida atualizar(Long id, Partida p) {
        Partida existente = buscarPorId(id);
        p.setId(existente.getId());
        return repo.save(p);
    }

    public void deletar(Long id) {
        Partida existente = buscarPorId(id);
        repo.delete(existente);
    }
}
