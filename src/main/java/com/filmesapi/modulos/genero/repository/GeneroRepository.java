package com.filmesapi.modulos.genero.repository;

import com.filmesapi.modulos.genero.model.Genero;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface GeneroRepository extends ReactiveMongoRepository<Genero, String> {

    Flux<Genero> findByNameLikeIgnoreCase(String nome);
}
