package com.gerenciadorcampeonatos.controller;

import com.gerenciadorcampeonatos.model.Campeonato;
import com.gerenciadorcampeonatos.service.CampeonatoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/campeonatos")
@CrossOrigin("*")
public class CampeonatoController {

    private final CampeonatoService service;

    public CampeonatoController(CampeonatoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Campeonato> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Campeonato buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Campeonato salvar(@RequestBody Campeonato c) {
        return service.salvar(c);
    }

    @PutMapping("/{id}")
    public Campeonato atualizar(@PathVariable Long id, @RequestBody Campeonato c) {
        return service.atualizar(id, c);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
