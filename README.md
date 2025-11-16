# API RESTful: Gerenciador de Campeonatos
## Projeto de API REST com Spring Boot e Spring Data JPA

---

## Tecnologias Principais
* **Linguagem:** Java 17+
* **Framework:** Spring Boot 3+
* **Persistência:** Spring Data JPA / Hibernate
* **Banco de Dados:** MySQL
* **Arquitetura:** 3 Camadas (Controller, Service, Repository)

---

## Script SQL de Criação do Banco (Requisito de Documentação)
O projeto utiliza o Spring Data JPA para criar as 8 tabelas automaticamente, mas o script abaixo define a estrutura do banco de dados (`db_campeonatos`) com base nas entidades modeladas.

```sql
CREATE DATABASE IF NOT EXISTS db_campeonatos;
USE db_campeonatos;

CREATE TABLE IF NOT EXISTS campeonato (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL UNIQUE,
    ano INT NOT NULL,
    status VARCHAR(255),
    data_inicio DATE,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS time (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL UNIQUE,
    cidade VARCHAR(255),
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tecnico (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255),
    idade INT,
    time_id BIGINT NOT NULL UNIQUE,
    PRIMARY KEY (id),
    FOREIGN KEY (time_id) REFERENCES time (id)
);

CREATE TABLE IF NOT EXISTS jogador (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    numero_camisa INT,
    time_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (time_id) REFERENCES time (id)
);

CREATE TABLE IF NOT EXISTS fase (
    id BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    campeonato_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (campeonato_id) REFERENCES campeonato (id)
);

CREATE TABLE IF NOT EXISTS partida (
    id BIGINT NOT NULL AUTO_INCREMENT,
    data_hora DATETIME(6) NOT NULL,
    placar_casa INT,
    placar_visitante INT,
    local VARCHAR(255),
    fase_id BIGINT NOT NULL,
    time_casa_id BIGINT NOT NULL,
    time_visitante_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (fase_id) REFERENCES fase (id),
    FOREIGN KEY (time_casa_id) REFERENCES time (id),
    FOREIGN KEY (time_visitante_id) REFERENCES time (id)
);

CREATE TABLE IF NOT EXISTS inscricao_campeonato (
    id BIGINT NOT NULL AUTO_INCREMENT,
    data_inscricao DATE,
    campeonato_id BIGINT NOT NULL,
    time_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (campeonato_id) REFERENCES campeonato (id),
    FOREIGN KEY (time_id) REFERENCES time (id)
);

CREATE TABLE IF NOT EXISTS estatistica_jogador (
    id BIGINT NOT NULL AUTO_INCREMENT,
    tipo_estatistica VARCHAR(255) NOT NULL,
    valor INT,
    jogador_id BIGINT NOT NULL,
    partida_id BIGINT NOT NULL,
    PRIMARY KEY (id),
    FOREIGN KEY (jogador_id) REFERENCES jogador (id),
    FOREIGN KEY (partida_id) REFERENCES partida (id)
);