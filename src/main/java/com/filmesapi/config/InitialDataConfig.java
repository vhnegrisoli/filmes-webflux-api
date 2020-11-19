package com.filmesapi.config;

import com.filmesapi.modulos.ator.model.Ator;
import com.filmesapi.modulos.filme.model.Filme;
import com.filmesapi.modulos.genero.model.Genero;
import com.filmesapi.modulos.ator.repository.AtorRepository;
import com.filmesapi.modulos.filme.repository.FilmeRepository;
import com.filmesapi.modulos.genero.repository.GeneroRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.FileReader;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class InitialDataConfig {

    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private AtorRepository atorRepository;
    @Autowired
    private GeneroRepository generoRepository;

    @PostConstruct
    public void inserirDadosIniciais() {
        filmeRepository.deleteAll().subscribe();
        log.info("Iniciando o processamento do arquivo filmes.json...");
        try {
            var filmes = lerFilmesDoArquivoJson();
            log.info("Inserindo ".concat(String.valueOf(filmes.size())).concat(" arquivos no MongoDB."));
            inserirAtores(filmes);
            inserirGeneros(filmes);
            filmeRepository.saveAll(filmes).subscribe();
            log.info("Finalizando.");
        } catch (Exception ex) {
            log.error("Erro ao inserir dados iniciais.", ex);
        }
    }

    private void inserirAtores(List<Filme> filmes) {
        var atores = filmes
            .stream()
            .flatMap(filme -> filme.getCast().stream())
            .filter(ator -> !ator.equals("."))
            .distinct()
            .map(Ator::new)
            .collect(Collectors.toList());
        atorRepository.saveAll(atores).subscribe();
    }

    private void inserirGeneros(List<Filme> filmes) {
        var generos = filmes
            .stream()
            .flatMap(filme -> filme.getGenres().stream())
            .filter(genero -> !genero.equals("."))
            .distinct()
            .map(Genero::new)
            .collect(Collectors.toList());
        generoRepository.saveAll(generos).subscribe();
    }

    @SneakyThrows
    private List<Filme> lerFilmesDoArquivoJson() {
        var parser = new JSONParser();
        var obj = parser.parse(new FileReader("data/filmes.json"));
        var filmes = ((JSONArray) obj)
            .stream()
            .map(Filme::converterDe)
            .distinct()
            .collect(Collectors.toList());
        return (List<Filme>) filmes;
    }
}

