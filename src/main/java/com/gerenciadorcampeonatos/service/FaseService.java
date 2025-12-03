package com.gerenciadorcampeonatos.service;

import com.gerenciadorcampeonatos.model.Fase;
import com.gerenciadorcampeonatos.repository.FaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FaseService {

    private final FaseRepository repo;

    public FaseService(FaseRepository repo) {
        this.repo = repo;
    }

    public List<Fase> listarTodos() {
        return repo.findAll();
    }

    public Fase buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Fase não encontrada"));
    }

    public Fase salvar(Fase f) {
        return repo.save(f);
    }

    public Fase atualizar(Long id, Fase f) {
        Fase existente = buscarPorId(id);
        f.setId(existente.getId());
        return repo.save(f);
    }

    public void deletar(Long id) {
        Fase existente = buscarPorId(id);
        repo.delete(existente);
    }
}
