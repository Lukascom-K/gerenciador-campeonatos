package com.gerenciadorcampeonatos.service;

import com.gerenciadorcampeonatos.model.Inscricao;
import com.gerenciadorcampeonatos.repository.InscricaoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InscricaoService {

    private final InscricaoRepository repo;

    public InscricaoService(InscricaoRepository repo) {
        this.repo = repo;
    }

    public List<Inscricao> listarTodos() {
        return repo.findAll();
    }

    public Inscricao buscarPorId(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Inscrição não encontrada"));
    }

    public Inscricao salvar(Inscricao obj) {
        return repo.save(obj);
    }

    public Inscricao atualizar(Long id, Inscricao obj) {
        Inscricao existente = buscarPorId(id);
        obj.setId(existente.getId());
        return repo.save(obj);
    }

    public void deletar(Long id) {
        Inscricao existente = buscarPorId(id);
        repo.delete(existente);
    }
}
