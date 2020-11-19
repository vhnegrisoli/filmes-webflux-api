package com.filmesapi.modulos.ator.model;

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
@Document(collection = "ator")
public class Ator {

    @Id
    private String id;
    private String name;

    public Ator(String name) {
        this.name = name;
    }
}