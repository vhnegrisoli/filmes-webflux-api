package com.filmesapi.modulos.filme.repository;

import com.filmesapi.modulos.filme.model.Filme;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FilmeRepository extends ReactiveMongoRepository<Filme, String> {
}
