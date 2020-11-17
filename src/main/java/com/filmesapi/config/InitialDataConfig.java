package com.filmesapi.config;

import com.filmesapi.modulos.filme.model.Filme;
import com.filmesapi.modulos.filme.repository.FilmeRepository;
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

    @PostConstruct
    public void initData() {
        filmeRepository.deleteAll();
        log.info("Iniciando o processamento do arquivo filmes.json...");
        try {
            var filmes = lerFilmesDoArquivoJson();
            log.info("Inserindo ".concat(String.valueOf(filmes.size())).concat(" arquivos no MongoDB."));
            filmeRepository.saveAll(filmes).subscribe();
            log.info("Finalizando.");
        } catch (Exception ex) {
            log.error("Erro ao inserir dados iniciais.", ex);
        }
    }

    @SneakyThrows
    private List<Filme> lerFilmesDoArquivoJson() {
        var parser = new JSONParser();
        var obj = parser.parse(new FileReader("data/filmes.json"));
        var filmes = ((JSONArray) obj)
            .stream()
            .map(Filme::converterDe)
            .collect(Collectors.toList());
        return (List<Filme>) filmes;
    }
}

