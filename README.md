# Projeto: Filmes WebFlux API


### Resumo

O Filmes WebFlux API é um projeto de desenvolvimento de uma API REST
de um repositório de filmes utilizando Java 11, Spring Boot, Spring WebFlux, Spring Data MongoDB e banco NoSQL MongoDB.
 
### Tecnologias

As principais tecnologias utilizadas neste projeto são: 

* **Java 11**
* **Spring Boot**
* **Spring WebFlux**
* **Spring Data MongoDB**
* **Reactive MongoDB Repositories**
* **MongoDB**
* **Docker**
* **Docker-compose**
* **API REST**
* **Gradle**

## Instalação e execução

É possível executar a aplicação manualmente pela IDE ou terminal, ou também
via container Docker e até mesmo com docker-compose.

#### Executando manualmente

Primeiramente, é necessário realizar a instalação das dependências, para isto, rode o comando:

`gradle build`

Em sequência, rode o comando:

`gradle bootRun`

Ou então:

`java -jar build/libs/.jar`

**Obs.: para rodar manualmente, é necessário ter uma instância do MongoDB 
rodando sem autenticação (padrão definido nas configurações do projeto para fins de desenvolvimento)
ou rodar o container do MongoDB separadamente do arquivo compose, para isto, veja o comando abaixo.**

#### Executando via Docker

Primeiramente, será necessário criar uma `network`, conforme o comando abaixo:

`docker network create filmes`

Depois, será necessário criar a imagem e rodar o container do MongoDB:

`docker run --network filmes --name filmes-db -p 27017:27017 -p 28017:28017 -e AUTH=no -d tutum/mongodb`

E, por fim, criar a imagem da API:

`docker image build -t filmes-api .`

Em sequência, rodar o container:

`docker container run --network filmes --name filmes-api -e SPRING_PROFILES_ACTIVE=docker -e MONGO_DB_HOST=filmes-db -e MONGO_DB_PORT=27017 -e MONGO_DB_DATABASE=webflux -p 8080:8080 -d filmes-api`

Para acompanhar os logs, basta executar o comando:

`docker logs --follow nome_do_container`

#### Executando via Docker-compose

Para executar todos os containers juntos, basta apenas rodar o comando:

`docker-compose up`

Caso queira ignorar os logs ao criar todos os containers, adicione flag `-d`.

Para parar os serviços inicializados pelo `compose`, basta rodar o comando:

`docker-compose stop`

## Disponibilização de acesso

A aplicação será dispinibilizada no endereço `http://localhost:8080`.

O banco de dados MongoDB estará disponbilizado no endereço `http://localhost:27017`.

#### Documentação

Toda a documentação será feita através do Swagger, e poderá ser encontrada no endereço:

[http://localhost:8080/swagger-ui/](http://localhost:8080/swagger-ui/)

![Documentação Swagger](https://github.com/vhnegrisoli/filmes-webflux-api/blob/main/imagens/Documenta%C3%A7%C3%A3o%20Swagger.png)

## Autores

* **Victor Hugo Negrisoli** - *Desenvolvedor Back-End* - [vhnegrisoli](https://github.com/vhnegrisoli)

## Licença

Este projeto possui a licença do MIT. Veja mais em: [LICENSE](LICENSE)
