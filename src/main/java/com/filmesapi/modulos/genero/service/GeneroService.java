package com.filmesapi.modulos.genero.service;

import com.filmesapi.modulos.genero.model.Genero;
import com.filmesapi.modulos.genero.repository.GeneroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GeneroService {

    @Autowired
    private GeneroRepository generoRepository;

    public Flux<Genero> buscarTodos() {
        return generoRepository.findAll();
    }

    public Mono<Genero> buscarPorId(String id) {
        return generoRepository.findById(id);
    }

    public Flux<Genero> buscarPorNome(String nome) {
        return generoRepository.findByNameLikeIgnoreCase(nome);
    }
}
