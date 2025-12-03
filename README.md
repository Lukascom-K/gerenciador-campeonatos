# Gerenciador de Campeonatos – Sistema Completo (Spring Boot + HTML/JS)

Aplicação completa para gerenciamento de campeonatos esportivos com CRUD de Campeonatos, Times, Jogadores, Técnicos, Fases, Partidas, Inscrições e Estatísticas.  
Backend desenvolvido em Spring Boot e frontend construído em HTML, CSS e JavaScript (Fetch API).

---

## Tecnologias Utilizadas

### Backend
- Java 17+
- Spring Boot
- Spring Web
- Spring Data JPA
- MySQL
- Maven
- Lombok
- Jakarta Validation

### Frontend
- HTML5
- CSS3
- JavaScript (Fetch API)


---

## Funcionalidades

### Campeonatos
- Criar campeonato
- Editar
- Listar
- Excluir

### Times
- CRUD completo
- Relacionamento com jogadores
- Relacionamento com técnico

### Jogadores
- CRUD completo
- Vinculados a um time

### Técnicos
- CRUD completo
- Relacionamento 1–1 com Time

### Fases
- Relacionadas a campeonatos
- CRUD completo

### Partidas
- Time da casa e visitante
- Registro de placar
- Relacionamento com fase

### Inscrições
- Inscrição de times em campeonatos
- CRUD completo

### Estatísticas
- Vinculadas a jogador e partida
- CRUD completo

---

## Como rodar o Backend

### Via IntelliJ IDEA
Abra o projeto e execute:

GerenciadorCampeonatosApplication


### Via Maven


mvn spring-boot:run


Backend disponível em:


http://localhost:8080


---

## Como rodar o Frontend

O frontend está em `src/main/resources/static/`.

Acesse pelo navegador:



http://localhost:8080/campeonatos.html

http://localhost:8080/times.html

http://localhost:8080/jogadores.html

http://localhost:8080/fases.html

http://localhost:8080/partidas.html

http://localhost:8080/inscricoes.html

http://localhost:8080/estatisticas.html


---

## Configuração do Banco de Dados

Arquivo `application.properties`:



spring.datasource.url=jdbc:mysql://localhost:3306/gerenciador?useSSL=false&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=none
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true


---

## Script SQL Completo

```sql
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
    numero_camisa INT,
    time_id BIGINT,
    FOREIGN KEY (time_id) REFERENCES times(id)
);

CREATE TABLE tecnicos (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    idade INT,
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
    data_partida DATETIME,
    fase_id BIGINT,
    time_casa_id BIGINT,
    time_visitante_id BIGINT,
    gols_casa INT,
    gols_visitante INT,
    FOREIGN KEY (fase_id) REFERENCES fases(id),
    FOREIGN KEY (time_casa_id) REFERENCES times(id),
    FOREIGN KEY (time_visitante_id) REFERENCES times(id)
);

CREATE TABLE inscricoes (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    data_inscricao DATE,
    campeonato_id BIGINT,
    time_id BIGINT,
    FOREIGN KEY (campeonato_id) REFERENCES campeonatos(id),
    FOREIGN KEY (time_id) REFERENCES times(id)
);

CREATE TABLE estatisticas (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    tipo VARCHAR(100),
    valor INT,
    jogador_id BIGINT,
    partida_id BIGINT,
    FOREIGN KEY (jogador_id) REFERENCES jogadores(id),
    FOREIGN KEY (partida_id) REFERENCES partidas(id)
);

Endpoints da API
Campeonatos
Método	Endpoint
GET	/api/v1/campeonatos
GET	/api/v1/campeonatos/{id}
POST	/api/v1/campeonatos
PUT	/api/v1/campeonatos/{id}
DELETE	/api/v1/campeonatos/{id}
Times
Método	Endpoint
GET	/api/v1/times
POST	/api/v1/times
GET	/api/v1/times/{id}
PUT	/api/v1/times/{id}
DELETE	/api/v1/times/{id}
Jogadores
Método	Endpoint
GET	/api/v1/jogadores
POST	/api/v1/jogadores
PUT	/api/v1/jogadores/{id}
DELETE	/api/v1/jogadores/{id}
Técnicos
Método	Endpoint
GET	/api/v1/tecnicos
POST	/api/v1/tecnicos
PUT	/api/v1/tecnicos/{id}
DELETE	/api/v1/tecnicos/{id}
Fases
Método	Endpoint
GET	/api/v1/fases
POST	/api/v1/fases
PUT	/api/v1/fases/{id}
DELETE	/api/v1/fases/{id}
Partidas
Método	Endpoint
GET	/api/v1/partidas
POST	/api/v1/partidas
PUT	/api/v1/partidas/{id}
DELETE	/api/v1/partidas/{id}
Inscrições
Método	Endpoint
GET	/api/v1/inscricoes
POST	/api/v1/inscricoes
PUT	/api/v1/inscricoes/{id}
DELETE	/api/v1/inscricoes/{id}
Estatísticas
Método	Endpoint
GET	/api/v1/estatisticas
POST	/api/v1/estatisticas
PUT	/api/v1/estatisticas/{id}
DELETE	/api/v1/estatisticas/{id}
Testes via Postman
Criar Campeonato
{
  "nome": "Campeonato Teste",
  "ano": 2025,
  "status": "Ativo",
  "dataInicio": "2025-01-01"
}

Criar Time
{
  "nome": "Time Azul",
  "cidade": "Curitiba"
}

Criar Jogador
{
  "nome": "Carlos Silva",
  "numeroCamisa": 10,
  "time": { "id": 1 }
}

Criar Estatística
{
  "tipo": "Gols",
  "valor": 2,
  "jogador": { "id": 1 },
  "partida": { "id": 1 }
}
