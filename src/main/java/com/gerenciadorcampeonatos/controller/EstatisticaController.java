package com.gerenciadorcampeonatos.controller;

import com.gerenciadorcampeonatos.model.Estatistica;
import com.gerenciadorcampeonatos.service.EstatisticaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/estatisticas")
@CrossOrigin("*")
public class EstatisticaController {

    private final EstatisticaService service;

    public EstatisticaController(EstatisticaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Estatistica> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Estatistica buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Estatistica salvar(@RequestBody Estatistica e) {
        return service.salvar(e);
    }

    @PutMapping("/{id}")
    public Estatistica atualizar(@PathVariable Long id, @RequestBody Estatistica e) {
        return service.atualizar(id, e);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
