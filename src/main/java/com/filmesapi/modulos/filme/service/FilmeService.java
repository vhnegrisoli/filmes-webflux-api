package com.filmesapi.modulos.filme.service;

import com.filmesapi.modulos.filme.model.Filme;
import com.filmesapi.modulos.filme.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class FilmeService {

    @Autowired
    private FilmeRepository filmeRepository;

    public Flux<Filme> buscarTodos() {
        return filmeRepository.findAll();
    }

    public Mono<Filme> buscarPorId(String id) {
        return filmeRepository.findById(id);
    }

    public Flux<Filme> buscarPorTitulo(String titulo) {
        return filmeRepository.findByTitleLikeIgnoreCase(titulo);
    }

    public Flux<Filme> buscarPorAno(Long ano) {
        return filmeRepository.findByYear(ano);
    }

    public Flux<Filme> buscarPorAtores(List<String> atores) {
        return filmeRepository.findByCastIn(atores);
    }

    public Flux<Filme> buscarPorGeneros(List<String> generos) {
        return filmeRepository.findByGenresIn(generos);
    }
}
