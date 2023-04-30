<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> develop
# CadastrUser
Este é um sistema de cadastro de usuários
A ideia desse projeto é criar uma aplicação completa que possa realizar CRUD de Usuarios, que contém informações como:

- nome
- idade
- email
- telefone
<<<<<<< HEAD
=======
# MarketControl
Sistema de controle de estoque de comércios.
>>>>>>> release/releaseFinal
=======
>>>>>>> develop


<<<<<<< HEAD
<<<<<<< HEAD
=======
>>>>>>> develop


## Endpoints
---

### -  Usuario
- cadastrar
- listar todos
- alterar
- mostrar detalhes

---
## Cadastrar Usuario
`POST` /cadastro/api/pessoa
<<<<<<< HEAD
=======
- [Cadastro de estabelecimento](#cadastrar-estabelecimento)
    - Cadastrar
    - Listar todos
    - Apagar
    - Alterar

- [Cadastro de setor](#cadastrar-setor)
    - Cadastrar
    - Listar todos
    - Apagar
    - Alterar
    
- [Cadastro de funcionario](#cadastrar-funcionario)
    - Cadastrar
    - Listar todos
    - Apagar
    - Alterar

- [Analise de estoque](#analise-de-estoque)
    - Listar produtos
    
- [Perfil do funcionario](#perfil-do-funcionario)
    - Alterar
    - Mostrar os detalhes
>>>>>>> release/releaseFinal

--- 

## Cadastrar Produto 
`POST` /marketcontrol/api/produto

| campo | tipo | obrigatorio | descricao 
|-----|:----:|:-----------:|---------
| descricao | texto | sim | uma breve descricao do produto com o no maximo 50 caracteres
| valor | decimal | sim | é o valor do produto. deve ser maior que zero 
| dataCadastro | data | sim | é a data do cadastro
| dataValidade | data | sim | é a data de validade
| quantidade | int | sim | é a quantidade do produto e deve ser maior que zero
| estabelecimento | estab. | sim | é uma referência ao estabelecimento em que o produto está cadastrado. Deve ser informado o id do estabelecimento previamente cadastrado
=======

| campo | tipo | obrigatorio | descricao
|-------|:----:|:-----------:|---------
| nome | string | sim | armazena o nome da pessoa no momento do cadastro
| idade | int | sim | armazena a idade da pessoa no momento do cadastro
| email | string | sim | armazena o email de contato da pessoa 
| telefone | int | nao | armazena o telefone de contato da pessoa
>>>>>>> develop

**Exemplo de corpo do request**

```js
{
    "nome" : "Lucas Costa",
    "idade" : 19,
    "email" : "lucasinfo@gmail.com",
    "telefone" : 11973455655
}
```

