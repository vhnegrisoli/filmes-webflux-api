package com.filmesapi.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties("app-config")
public class AppProperties {

    private String nome;
    private String descricao;
    private String versao;
    private String url;
}
