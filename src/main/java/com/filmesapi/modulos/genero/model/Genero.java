package com.filmesapi.modulos.genero.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "genero")
public class Genero {

    @Id
    private String id;
    private String name;

    public Genero(String name) {
        this.name = name;
    }
}
