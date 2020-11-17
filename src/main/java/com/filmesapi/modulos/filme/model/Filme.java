package com.filmesapi.modulos.filme.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "filme")
public class Filme {

    @Id
    private String id;
    private String title;
    private Long year;
    private List<String> cast;
    private List<String> genres;

    @SneakyThrows
    public static Filme converterDe(String filmeJson) {
        return new ObjectMapper().readValue(filmeJson, Filme.class);
    }

    public static Filme converterDe(Object jsonObject) {
        var json = (JSONObject) jsonObject;
        return Filme
            .builder()
            .title(converterParaString(json.get("title")))
            .year((long) json.get("year"))
            .cast(converterParaListaString(json.get("cast")))
            .genres(converterParaListaString(json.get("genres")))
            .build();
    }

    private static String converterParaString(Object valor) {
        try {
            return (String) valor;
        } catch (Exception ex) {
            return null;
        }
    }

    private static Integer converterParaInteger(Object valor) {
        try {
            return (int) valor;
        } catch (Exception ex) {
            return null;
        }
    }

    private static List<String> converterParaListaString(Object valor) {
        try {
            var lista = (JSONArray) valor;
            return (List<String>) lista
                .stream()
                .map(Filme::converterParaString)
                .collect(Collectors.toList());
        } catch (Exception ex) {
            return Collections.emptyList();
        }
    }
}
