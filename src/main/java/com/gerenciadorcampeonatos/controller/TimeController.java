package com.gerenciadorcampeonatos.controller;

import com.gerenciadorcampeonatos.model.Time;
import com.gerenciadorcampeonatos.service.TimeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/times")
@CrossOrigin("*")
public class TimeController {

    private final TimeService service;

    public TimeController(TimeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Time> listar() {
        return service.listarTodos();
    }

    @GetMapping("/{id}")
    public Time buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Time salvar(@RequestBody Time t) {
        return service.salvar(t);
    }

    @PutMapping("/{id}")
    public Time atualizar(@PathVariable Long id, @RequestBody Time t) {
        return service.atualizar(id, t);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
