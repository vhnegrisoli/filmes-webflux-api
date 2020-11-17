package com.filmesapi.modulos.filme.repository;

import com.filmesapi.modulos.filme.model.Filme;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface FilmeRepository extends ReactiveMongoRepository<Filme, String> {

    Flux<Filme> findByTitleLikeIgnoreCase(String nome);

    Flux<Filme> findByYear(Long ano);

    Flux<Filme> findByCastIn(List<String> atores);

    Flux<Filme> findByGenresIn(List<String> generos);
}
