# README

Projeto para finalização da disciplina de CI/CD do curso de DevOps na FIAP.

Plataforma de jogos educacionais com base em gamificação focado em alunos de 5 a 10 anos de instituições de ensino para complementação do ensino a distância.

## Exemplos de endpoints:

**Cadastro de escolas**

http://{IP}/api/schools
POST
{
    "id": 1,
    "name": "Fiap",
    "country": "Brazil"
}

**Obtenção de todas as escolas cadastradas**

http://{IP}/api/schools
GET

**Obtenção de escola por ID**

http://{IP}/api/schools/{id}
GET

**Cadastro de alunos**

http://{IP}/api/users
POST
{
    "id": 1,
    "name": "Pablo",
    "birthday": "2015-05-03",
    "school": {
        "id" : 1
    }
}

**Obtenção de todos os alunos cadastrados**

http://{IP}/api/users
GET

**Obtenção de aluno por ID**

http://{IP}/api/users/{id}
GET

**Cadastro de jogos**

http://{IP}/api/games
POST
{
    "id": 1,
    "name": "Some mysterious shadows",
    "developer": "pffelipe"
}

**Obtenção de todos os jogos cadastrados**

http://{IP}/api/games
GET

**Obtenção de jogo  por ID**

http://{IP}/api/games/{id}
GET

**Mapeamento de jogos utilizados por alunos**

http://localhost:8080/api/users/1/games/1
POST

```
