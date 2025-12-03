package com.gerenciadorcampeonatos.controller;

import com.gerenciadorcampeonatos.model.Jogador;
import com.gerenciadorcampeonatos.service.JogadorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/jogadores")
@CrossOrigin("*")
public class JogadorController {

    private final JogadorService service;

    public JogadorController(JogadorService service) {
        this.service = service;
    }

    @GetMapping
    public List<Jogador> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Jogador buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Jogador salvar(@RequestBody Jogador j) {
        return service.salvar(j);
    }

    @PutMapping("/{id}")
    public Jogador atualizar(@PathVariable Long id, @RequestBody Jogador j) {
        return service.atualizar(id, j);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
