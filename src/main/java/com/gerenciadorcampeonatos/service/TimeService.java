package com.gerenciadorcampeonatos.service;

import com.gerenciadorcampeonatos.model.Time;
import com.gerenciadorcampeonatos.repository.TimeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimeService {

    private final TimeRepository repo;

    public TimeService(TimeRepository repo) {
        this.repo = repo;
    }

    public List<Time> listarTodos() {
        return repo.findAll();
    }

    public Time buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Time não encontrado"));
    }

    public Time salvar(Time t) {
        return repo.save(t);
    }

    public Time atualizar(Long id, Time t) {
        Time existente = buscarPorId(id);
        t.setId(existente.getId());
        return repo.save(t);
    }

    public void deletar(Long id) {
        Time existente = buscarPorId(id);
        repo.delete(existente);
    }
}
