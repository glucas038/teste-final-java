# Projeto final Minsait

Projeto consiste em um programa que cadastra clientes e emprestismos para esses clientes seguindo algumas regras.

## Para poder fazer POST via POSTMAN 
Utilizar o seguinte arquivo JSON para clientes, sendo todos dados obrigatórios:

{
    "cpf": "",
    "nome": "",
    "telefone": "",
    "rendimentoMensal": 0,
    "endereco": {
        "rua": "",
        "numero":0 ,
        "cep": ""
    }
}

Utilizar o seguinte arquivio JSON para emprestimos, sendo todos dados obrigatórios:

{
    "valorInicial": 0,
    "relacionamento": 0,
    "diaFinal": 1,
    "mesFinal": 1,
    "anoFinal": 2000
}