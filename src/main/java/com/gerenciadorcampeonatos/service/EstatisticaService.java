package com.gerenciadorcampeonatos.service;

import com.gerenciadorcampeonatos.model.Estatistica;
import com.gerenciadorcampeonatos.repository.EstatisticaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstatisticaService {

    private final EstatisticaRepository repo;

    public EstatisticaService(EstatisticaRepository repo) {
        this.repo = repo;
    }

    public List<Estatistica> listarTodos() {
        return repo.findAll();
    }

    public Estatistica buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Estatística não encontrada"));
    }

    public Estatistica salvar(Estatistica obj) {
        return repo.save(obj);
    }

    public Estatistica atualizar(Long id, Estatistica obj) {
        Estatistica existente = buscarPorId(id);
        obj.setId(existente.getId());
        return repo.save(obj);
    }

    public void deletar(Long id) {
        Estatistica existente = buscarPorId(id);
        repo.delete(existente);
    }
}
