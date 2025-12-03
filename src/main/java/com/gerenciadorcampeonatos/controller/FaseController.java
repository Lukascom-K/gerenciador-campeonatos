package com.gerenciadorcampeonatos.controller;

import com.gerenciadorcampeonatos.model.Fase;
import com.gerenciadorcampeonatos.service.FaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fases")
@CrossOrigin("*")
public class FaseController {

    private final FaseService service;

    public FaseController(FaseService service) {
        this.service = service;
    }

    @GetMapping
    public List<Fase> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Fase buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Fase salvar(@RequestBody Fase f) {
        return service.salvar(f);
    }

    @PutMapping("/{id}")
    public Fase atualizar(@PathVariable Long id, @RequestBody Fase f) {
        return service.atualizar(id, f);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
