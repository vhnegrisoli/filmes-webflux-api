package com.filmesapi.modulos.filme.controller;

import com.filmesapi.modulos.filme.model.Filme;
import com.filmesapi.modulos.filme.service.FilmeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/filmes")
public class FilmeController {

    @Autowired
    private FilmeService filmeService;

    @GetMapping
    public Flux<Filme> buscarTodos() {
        return filmeService.buscarTodos();
    }

    @GetMapping("{id}")
    public Mono<Filme> buscarPorId(@PathVariable String id) {
        return filmeService.buscarPorId(id);
    }

    @GetMapping("titulo/{titulo}")
    public Flux<Filme> buscarPorNome(@PathVariable String titulo) {
        return filmeService.buscarPorTitulo(titulo);
    }

    @GetMapping("ano/{ano}")
    public Flux<Filme> buscarPorAno(@PathVariable Long ano) {
        return filmeService.buscarPorAno(ano);
    }

    @GetMapping("atores")
    public Flux<Filme> buscarPorAtores(@RequestParam List<String> atores) {
        return filmeService.buscarPorAtores(atores);
    }

    @GetMapping("generos")
    public Flux<Filme> buscarPorGeneros(@RequestParam List<String> generos) {
        return filmeService.buscarPorGeneros(generos);
    }
}
