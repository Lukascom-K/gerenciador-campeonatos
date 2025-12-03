package com.gerenciadorcampeonatos.controller;

import com.gerenciadorcampeonatos.model.Tecnico;
import com.gerenciadorcampeonatos.service.TecnicoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/tecnicos")
@CrossOrigin("*")
public class TecnicoController {

    private final TecnicoService service;

    public TecnicoController(TecnicoService service) {
        this.service = service;
    }

    @GetMapping
    public List<Tecnico> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Tecnico buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Tecnico salvar(@RequestBody Tecnico t) {
        return service.salvar(t);
    }

    @PutMapping("/{id}")
    public Tecnico atualizar(@PathVariable Long id, @RequestBody Tecnico t) {
        return service.atualizar(id, t);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
