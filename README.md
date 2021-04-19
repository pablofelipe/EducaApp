# README

Projeto para finalização da disciplina de CI/CD do curso de DevOps na FIAP.

Plataforma de jogos educacionais com base em gamificação focado em alunos de 5 a 10 anos de instituições de ensino para complementação do ensino a distância.

## Exemplos de endpoints:

**Cadastro de escolas**
```
POST http://{IP}/api/schools
```
```
{
    "id": 1,
    "name": "Fiap",
    "country": "Brazil"
}
```
**Obtenção de todas as escolas cadastradas**

```
GET http://{IP}/api/schools
```


**Obtenção de escola por ID**
```
GET http://{IP}/api/schools/{id}
```

**Cadastro de alunos**
```
POST http://{IP}/api/users
```
```
{
    "id": 1,
    "name": "Pablo",
    "birthday": "2015-05-03",
    "school": {
        "id" : 1
    }
}
```
**Obtenção de todos os alunos cadastrados**
```
GET http://{IP}/api/users
```


**Obtenção de aluno por ID**
```
GET http://{IP}/api/users/{id}
```

**Cadastro de jogos**
```
POST http://{IP}/api/games
```
```
{
    "id": 1,
    "name": "Some mysterious shadows",
    "developer": "pffelipe"
}
```
**Obtenção de todos os jogos cadastrados**
```
GET http://{IP}/api/games
```

**Obtenção de jogo  por ID**
```
GET http://{IP}/api/games/{id}
```

**Mapeamento de jogos utilizados por alunos**

```
POST http://{IP}/api/users/1/games/1
```
