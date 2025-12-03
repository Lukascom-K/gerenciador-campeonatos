package com.gerenciadorcampeonatos.service;

import com.gerenciadorcampeonatos.model.Tecnico;
import com.gerenciadorcampeonatos.repository.TecnicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TecnicoService {

    private final TecnicoRepository repo;

    public TecnicoService(TecnicoRepository repo) {
        this.repo = repo;
    }

    public List<Tecnico> listarTodos() {
        return repo.findAll();
    }

    public Tecnico buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Técnico não encontrado"));
    }

    public Tecnico salvar(Tecnico t) {
        return repo.save(t);
    }

    public Tecnico atualizar(Long id, Tecnico t) {
        Tecnico existente = buscarPorId(id);
        t.setId(existente.getId());
        return repo.save(t);
    }

    public void deletar(Long id) {
        Tecnico existente = buscarPorId(id);
        repo.delete(existente);
    }
}
