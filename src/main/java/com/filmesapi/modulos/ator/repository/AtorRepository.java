package com.filmesapi.modulos.ator.repository;

import com.filmesapi.modulos.ator.model.Ator;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface AtorRepository extends ReactiveMongoRepository<Ator, String> {

    Flux<Ator> findByNameLikeIgnoreCase(String nome);
}
