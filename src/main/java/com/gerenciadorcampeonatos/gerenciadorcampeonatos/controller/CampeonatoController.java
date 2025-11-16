// src/main/java/com/gerenciadorcampeonatos/controller/CampeonatoController.java

package com.gerenciadorcampeonatos.controller;

import com.gerenciadorcampeonatos.model.Campeonato;
import com.gerenciadorcampeonatos.service.CampeonatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController // Marca a classe como um Controller REST
@RequestMapping("/api/campeonatos") // Define o caminho base da API
public class CampeonatoController {

    @Autowired // Injeção de Dependência da lógica de negócio
    private CampeonatoService campeonatoService;

    // 1. ENDPOINT: CREATE (POST)
    @PostMapping
    public ResponseEntity<Campeonato> criarCampeonato(@RequestBody Campeonato campeonato) {
        Campeonato novoCampeonato = campeonatoService.salvar(campeonato);
        // Retorna status 201 (Created)
        return new ResponseEntity<>(novoCampeonato, HttpStatus.CREATED);
    }

    // 2. ENDPOINT: READ ALL (GET)
    @GetMapping
    public ResponseEntity<List<Campeonato>> listarCampeonatos() {
        List<Campeonato> campeonatos = campeonatoService.listarTodos();
        // Retorna status 200 (OK)
        return new ResponseEntity<>(campeonatos, HttpStatus.OK);
    }

    // 3. ENDPOINT: READ ONE (GET by ID)
    @GetMapping("/{id}")
    public ResponseEntity<Campeonato> buscarCampeonatoPorId(@PathVariable Long id) {
        Optional<Campeonato> campeonato = campeonatoService.buscarPorId(id);

        // Verifica se o Campeonato existe
        return campeonato.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // 4. ENDPOINT: UPDATE (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Campeonato> atualizarCampeonato(@PathVariable Long id, @RequestBody Campeonato detalhesCampeonato) {
        Optional<Campeonato> campeonatoExistente = campeonatoService.buscarPorId(id);

        if (campeonatoExistente.isPresent()) {
            Campeonato campeonatoAtual = campeonatoExistente.get();

            // Atualiza apenas os campos que vieram no corpo da requisição
            campeonatoAtual.setNome(detalhesCampeonato.getNome());
            campeonatoAtual.setAno(detalhesCampeonato.getAno());
            campeonatoAtual.setStatus(detalhesCampeonato.getStatus());
            campeonatoAtual.setDataInicio(detalhesCampeonato.getDataInicio());

            Campeonato campeonatoAtualizado = campeonatoService.salvar(campeonatoAtual);
            return ResponseEntity.ok(campeonatoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // 5. ENDPOINT: DELETE (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarCampeonato(@PathVariable Long id) {
        Optional<Campeonato> campeonatoExistente = campeonatoService.buscarPorId(id);

        if (campeonatoExistente.isPresent()) {
            campeonatoService.deletar(id);
            // Retorna status 204 (No Content) - sucesso na exclusão
            return ResponseEntity.noContent().build();
        } else {
            // Retorna status 404 (Not Found)
            return ResponseEntity.notFound().build();
        }
    }
}