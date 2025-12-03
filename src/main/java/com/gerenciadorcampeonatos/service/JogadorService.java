package com.gerenciadorcampeonatos.service;

import com.gerenciadorcampeonatos.model.Jogador;
import com.gerenciadorcampeonatos.repository.JogadorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JogadorService {

    private final JogadorRepository repo;

    public JogadorService(JogadorRepository repo) {
        this.repo = repo;
    }

    public List<Jogador> listarTodos() {
        return repo.findAll();
    }

    public Jogador buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Jogador não encontrado"));
    }

    public Jogador salvar(Jogador j) {
        return repo.save(j);
    }

    public Jogador atualizar(Long id, Jogador j) {
        Jogador existente = buscarPorId(id);
        j.setId(existente.getId());
        return repo.save(j);
    }

    public void deletar(Long id) {
        Jogador existente = buscarPorId(id);
        repo.delete(existente);
    }
}
