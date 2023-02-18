# API COM TODAS AS PROVINCIAS E DISTRITOS DE MOÇAMBIQUE

Esta API possui todas as provincias e distritos de Moçambique e pode ser integrada em qualquer projecto.

O projecto foi desenvolvido usando python django, ou seja, a aplicação location pode ser facilmente integrada em qualquer outro projecto django.

Para mais informações sobre o django eis o link https://docs.djangoproject.com/en/4.1/

Para fazer requests a api online é só substituir o http://127.0.0.1:8000/ por https://moz-regional-prod-production.up.railway.app/

Todos os requests desta API são GET.

# BUSCAR TODAS AS PROVINCIAS

Para buscar todas as provincias usamos o endpoint (GET): http://127.0.0.1:8000/api/mz/provincias. O corpo da resposta será:

{
"success": true,
"status_code": 200,
"message": "Provincias de Moçambique.",
"data": [
{
"id": 1,
"province_name": "Cidade de Maputo",
"acronym": "MPC",
"zone": "Zona Sul"
},
{
...
}
]
}

# BUSCAR UMA PROVINCIA ESPECIFICA OU VÁRIAS COM MESMO NOME OU SINTAXE

Para buscar uma provincia especifica podemos usar o endpoint (GET): http://127.0.0.1:8000/api/mz/provincias/{idDaProvincia} ou também podemos filtrar pelo nome da provincia usando http://127.0.0.1:8000/api/mz/provincias/s/{nomeProvincia}

O corpo da resposta será:

{
"success": true,
"status_code": 200,
"message": "Provincia com o id 1 (ou nome).",
"data": {
"id": 1,
"province_name": "Cidade de Maputo",
"acronym": "MPC",
"zone": "Zona Sul"
}
}

# FILTRAR PROVINCIAS PELA ZONA

Podemos também filtar as provincias pela zona onde estas se encontram, sendo:

Zona Sul = 1
Zona Centro = 2
Zona Norte = 3

E usamos o endpoint http://127.0.0.1:8000/api/mz/provincias/zona/{idDaZona}. O corpo da resposta será:

{
"success": true,
"status_code": 200,
"message": "Provincias de Moçambique da zona: 1.",
"data": [
{
"id": 1,
"province_name": "Cidade de Maputo",
"acronym": "MPC",
"zone": "Zona Sul"
},
{
...
}
]
}

# BUSCAR TODOS OS DISTRITOS

Para buscar todos as provincias podemos usar o endpoint: http://127.0.0.1:8000/api/mz/distritos

O conteúdo da resposta será:

{
"success": true,
"status_code": 200,
"message": "Distritos de Moçambique.",
"data": [
{
"id": 1,
"province_name": "Cidade de Maputo",
"district_name": "Distrito de KaMpfumo"
},
]
}

# BUSCAR UM DISTRITO ESPECIFICO PELO ID

Para buscar um distrito especifico usamos o endpoint: http://127.0.0.1:8000/api/mz/distritos/{idDoDistrito}

O conteudo da resposta será:

{
"success": true,
"status_code": 200,
"message": "Distrito com o id 1.",
"data": {
"id": 1,
"province_name": "Cidade de Maputo",
"district_name": "Distrito de KaMpfumo"
}
}

# FILTRAR DISTRITOS PELA PROVINCIA

Podemos também filtrar os distritos de uma provincia em especifico usando o endpoint http://127.0.0.1:8000/api/mz/distritos/p/{idDaProvincia}

O conteúdo da resposta será:

{
"success": true,
"status_code": 200,
"message": "Distritos da provincia com o ID: 1.",
"data": [
{
"id": 1,
"province_name": "Cidade de Maputo",
"district_name": "Distrito de KaMpfumo"
},
{
...
}
]
}
