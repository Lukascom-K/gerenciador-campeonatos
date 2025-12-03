Gerenciador de Campeonatos – API REST com Spring Boot

Este projeto consiste em uma aplicação completa para gerenciamento de campeonatos esportivos, incluindo entidades como campeonatos, times, jogadores, técnicos, fases, partidas, inscrições e estatísticas.
A API foi construída seguindo boas práticas de arquitetura, camada de serviço, repositórios JPA, validação com Bean Validation e comunicação REST.

A aplicação inclui também um front-end simples desenvolvido com HTML, CSS e JavaScript, permitindo interação direta com os endpoints.

Descrição Geral do Projeto

O sistema permite o gerenciamento das seguintes entidades:

Campeonatos

Times

Jogadores

Técnicos

Fases

Partidas

Inscrições

Estatísticas

Cada entidade possui operações completas de CRUD expostas através de uma API RESTful, seguindo o padrão /api/v1.

A persistência é feita em banco MySQL utilizando Spring Data JPA.
Foi implementado tratamento global de exceções e validações de campos obrigatórios.

O front-end acessa diretamente os endpoints através de requisições AJAX usando Fetch API.

Tecnologias Utilizadas

Java 17

Spring Boot

Spring MVC

Spring Data JPA

MySQL

Hibernate

Lombok

Jakarta Validation

Maven

HTML, CSS e JavaScript (Fetch API)

Como Executar o Projeto
Clonar o repositório
git clone https://github.com/SEU_USUARIO/SEU_REPOSITORIO.git
cd SEU_REPOSITORIO

Configurar o banco de dados

Crie um banco com o nome:

gerenciador


Agora cole o script SQL completo (pronto para uso) no phpMyAdmin, DBeaver ou MySQL CLI.

Script SQL Completo – Banco 100% Pronto
CREATE DATABASE IF NOT EXISTS gerenciador;
USE gerenciador;

CREATE TABLE campeonatos (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
ano INT,
status VARCHAR(50),
data_inicio DATE
);

CREATE TABLE times (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
cidade VARCHAR(100)
);

CREATE TABLE jogadores (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
idade INT,
posicao VARCHAR(50),
time_id BIGINT,
FOREIGN KEY (time_id) REFERENCES times(id)
);

CREATE TABLE tecnicos (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100) NOT NULL,
experiencia INT,
time_id BIGINT UNIQUE,
FOREIGN KEY (time_id) REFERENCES times(id)
);

CREATE TABLE fases (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
nome VARCHAR(100),
campeonato_id BIGINT,
FOREIGN KEY (campeonato_id) REFERENCES campeonatos(id)
);

CREATE TABLE partidas (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
data_partida DATE,
local_partida VARCHAR(200),
time_casa_id BIGINT,
time_fora_id BIGINT,
campeonato_id BIGINT,
fase_id BIGINT,
FOREIGN KEY (time_casa_id) REFERENCES times(id),
FOREIGN KEY (time_fora_id) REFERENCES times(id),
FOREIGN KEY (campeonato_id) REFERENCES campeonatos(id),
FOREIGN KEY (fase_id) REFERENCES fases(id)
);

CREATE TABLE inscricoes (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
jogador_id BIGINT,
campeonato_id BIGINT,
data_inscricao DATE,
FOREIGN KEY (jogador_id) REFERENCES jogadores(id),
FOREIGN KEY (campeonato_id) REFERENCES campeonatos(id)
);

CREATE TABLE estatisticas (
id BIGINT PRIMARY KEY AUTO_INCREMENT,
gols INT,
assistencias INT,
faltas INT,
jogador_id BIGINT,
FOREIGN KEY (jogador_id) REFERENCES jogadores(id)
);

Configuração do application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/gerenciador?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

Executar o projeto

Via IntelliJ (botão Run) ou via terminal:

mvn spring-boot:run


A API estará disponível em:

http://localhost:8080/api/v1


E o front-end poderá ser acessado diretamente via arquivos HTML em:

src/main/resources/static/

Endpoints da API

A API segue o padrão:

/api/v1/{entidade}


Exemplos:

Campeonatos

GET /api/v1/campeonatos

POST /api/v1/campeonatos

GET /api/v1/campeonatos/{id}

PUT /api/v1/campeonatos/{id}

DELETE /api/v1/campeonatos/{id}

Times

GET /api/v1/times

POST /api/v1/times

Jogadores

GET /api/v1/jogadores

POST /api/v1/jogadores

Técnicos

GET /api/v1/tecnicos

POST /api/v1/tecnicos

Fases

GET /api/v1/fases

POST /api/v1/fases

Partidas

GET /api/v1/partidas

POST /api/v1/partidas

Inscrições

GET /api/v1/inscricoes

POST /api/v1/inscricoes

Estatísticas

GET /api/v1/estatisticas

POST /api/v1/estatisticas

Testes recomendados (Postman / Insomnia)
Criar Campeonato

POST /api/v1/campeonatos

{
"nome": "Campeonato Teste",
"ano": 2025,
"status": "Ativo",
"dataInicio": "2025-01-01"
}

Criar Time

POST /api/v1/times

{
"nome": "Time Azul",
"cidade": "Curitiba"
}

Criar Jogador

POST /api/v1/jogadores

{
"nome": "Carlos Silva",
"idade": 22,
"posicao": "Atacante",
"time": { "id": 1 }
}

Criar Estatística

POST /api/v1/estatisticas

{
"gols": 2,
"assistencias": 1,
"faltas": 0,
"jogador": { "id": 1 }
}

Sobre o Front-End

Todos os arquivos HTML, CSS e JavaScript estão em:

src/main/resources/static/


Cada página possui um JS próprio que realiza chamadas à API usando Fetch API.
O front permite:

Listar registros

Cadastrar

Editar

Excluir

Considerações Finais

Este projeto atende aos requisitos solicitados na disciplina, incluindo:

API REST completa

Camada Controller, Service e Repository

Persistência em MySQL

Validações

Tratamento global de erros

Documentação

Versionamento

Testes

Front integrado com o backend