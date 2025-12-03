package com.gerenciadorcampeonatos.controller;

import com.gerenciadorcampeonatos.model.Partida;
import com.gerenciadorcampeonatos.service.PartidaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/partidas")
@CrossOrigin("*")
public class PartidaController {

    private final PartidaService service;

    public PartidaController(PartidaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Partida> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Partida buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Partida salvar(@RequestBody Partida p) {
        return service.salvar(p);
    }

    @PutMapping("/{id}")
    public Partida atualizar(@PathVariable Long id, @RequestBody Partida p) {
        return service.atualizar(id, p);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
