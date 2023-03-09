# projeto web
trata-se de um projeto java-web
primeiramente a ideia é criar um projeto web com login e cadastro


### Endpoints
---

### -  Pessoa
- cadastrar
- listar todos
- alterar
- mostrar detalhes

---
## Cadastrar pessoa
`POST` /cadastro/api/pessoa

| campo | tipo | obrigatorio | descricao
|-------|:----:|:-----------:|---------
| nome | string | sim | armazena o nome da pessoa no momento do cadastro
| idade | int | sim | armazena a idade da pessoa no momento do cadastro
| email | string | sim | armazena o email de contato da pessoa 
| telefone | int | nao | armazena o telefone de contato da pessoa

**Exemplo de corpo do request**

```js
{
    "nome" : "Lucas Costa",
    "idade" : 19,
    "email" : "lucasinfo@gmail.com",
    "telefone" : 11973455655
}
```

