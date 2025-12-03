package com.gerenciadorcampeonatos.controller;

import com.gerenciadorcampeonatos.model.Inscricao;
import com.gerenciadorcampeonatos.service.InscricaoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/inscricoes")
@CrossOrigin("*")
public class InscricaoController {

    private final InscricaoService service;

    public InscricaoController(InscricaoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Inscricao> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Inscricao buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Inscricao salvar(@RequestBody Inscricao i) {
        return service.salvar(i);
    }

    @PutMapping("/{id}")
    public Inscricao atualizar(@PathVariable Long id, @RequestBody Inscricao i) {
        return service.atualizar(id, i);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
