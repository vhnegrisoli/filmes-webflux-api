package com.filmesapi.modulos.genero.controller;

import com.filmesapi.modulos.genero.model.Genero;
import com.filmesapi.modulos.genero.service.GeneroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/generos")
public class GeneroController {

    @Autowired
    private GeneroService generoService;

    @GetMapping
    public Flux<Genero> buscarTodos() {
        return generoService.buscarTodos();
    }

    @GetMapping("{id}")
    public Mono<Genero> buscarPorId(@PathVariable String id) {
        return generoService.buscarPorId(id);
    }

    @GetMapping("nome/{nome}")
    public Flux<Genero> buscarPorNome(@PathVariable String nome) {
        return generoService.buscarPorNome(nome);
    }
}