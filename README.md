
README

http://{IP}/api/schools
POST
{
    "id": 1,
    "name": "Fiap",
    "country": "Brazil"
}

http://{IP}/api/schools
GET

http://{IP}/api/schools/{id}
GET

http://{IP}/api/users
POST
{
    "id": 1,
    "name": "Pablo",
    "birthday": "2010-05-03",
    "school": {
        "id" : 1
    }
}

http://{IP}/api/users
GET

http://{IP}/api/users/{id}
GET


http://{IP}/api/games
POST
{
    "id": 1,
    "name": "Some mysterious shadows",
    "developer": "pffelipe"
}

http://localhost:8080/api/users/1/games/1
POST
