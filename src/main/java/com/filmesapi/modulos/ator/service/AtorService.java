package com.filmesapi.modulos.ator.service;

import com.filmesapi.modulos.ator.model.Ator;
import com.filmesapi.modulos.ator.repository.AtorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AtorService {

    @Autowired
    private AtorRepository atorRepository;

    public Flux<Ator> buscarTodos() {
        return atorRepository.findAll();
    }

    public Mono<Ator> buscarPorId(String id) {
        return atorRepository.findById(id);
    }

    public Flux<Ator> buscarPorNome(String nome) {
        return atorRepository.findByNameLikeIgnoreCase(nome);
    }
}
