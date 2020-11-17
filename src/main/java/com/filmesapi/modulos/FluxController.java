package com.filmesapi.modulos;

import com.filmesapi.modulos.filme.model.Filme;
import com.filmesapi.modulos.filme.repository.FilmeRepository;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Slf4j
@RestController
@RequestMapping("/api/teste")
public class FluxController {

    @Autowired
    private FilmeRepository filmeRepository;

    @GetMapping("dados")
    public Flux<Filme> buscarTodos() {
        return filmeRepository.findAll();
    }

    @SneakyThrows
    @GetMapping("1")
    public Flux<String> gerarListaAleatoria() {
        log.info("Método 1 - "
            .concat(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))));
        for (int i = 0; i < 10; i++) {
            log.info(String.valueOf(i));
            Thread.sleep(1000);
        }
        var strings = IntStream
            .range(1, gerarNumeroAleatorioEntre())
            .mapToObj(i -> "\n|"
                .concat(RandomStringUtils.randomAlphabetic(1, gerarNumeroAleatorioEntre()))
                .concat("|\n")
            )
            .collect(Collectors.toList());
        return Flux.fromStream(strings.stream());
    }

    @GetMapping("2")
    public Flux<String> gerarListaAleatoria2() {
        log.info("Método 2");
        var strings = IntStream
            .range(1, gerarNumeroAleatorioEntre())
            .mapToObj(i -> "\n|"
                .concat(RandomStringUtils.randomAlphabetic(1, gerarNumeroAleatorioEntre()))
                .concat("|\n")
            )
            .collect(Collectors.toList());
        return Flux.fromStream(strings.stream());
    }

    public static Integer gerarNumeroAleatorioEntre() {
        return new Random()
            .ints(10, 1000)
            .findFirst()
            .getAsInt();
    }
}
