package com.filmesapi.modulos.ator.controller;

import com.filmesapi.modulos.ator.model.Ator;
import com.filmesapi.modulos.ator.service.AtorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/atores")
public class AtorController {

    @Autowired
    private AtorService atorService;

    @GetMapping
    public Flux<Ator> buscarTodos() {
        return atorService.buscarTodos();
    }

    @GetMapping("{id}")
    public Mono<Ator> buscarPorId(@PathVariable String id) {
        return atorService.buscarPorId(id);
    }

    @GetMapping("nome/{nome}")
    public Flux<Ator> buscarPorNome(@PathVariable String nome) {
        return atorService.buscarPorNome(nome);
    }
}