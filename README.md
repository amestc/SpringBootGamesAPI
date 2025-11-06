# SpringBootGamesAPI

# 🎮 SpringBootGamesAPI

API RESTful feita com Java Spring Boot para gerenciamento de um catálogo de jogos, com persistência dos dados em um arquivo JSON e front-end web para operações CRUD.

---

## **Sobre**

Este projeto permite gerenciar uma lista de jogos digitais, incluindo cadastro, edição, exclusão e visualização, tanto via API quanto via interface web. Os dados são salvos em arquivo JSON para fácil manipulação.

---

## **🔑 Estrutura de Dados**

O recurso principal da API é o objeto **Game**.  
Abaixo o significado de cada variável/campo utilizado no modelo:

| Variável        | Tipo         | Descrição                                              | Exemplo                      |
|-----------------|--------------|--------------------------------------------------------|------------------------------|
| **id**              | Long         | Identificador único do jogo (gerado automaticamente)   | 1                            |
| **titulo**          | String       | Nome/título do jogo                                   | "Hollow Knight"              |
| **desenvolvedora**  | String       | Empresa ou pessoa responsável pelo desenvolvimento     | "Team Cherry"                |
| **genero**          | String       | Gênero do jogo (ex: "Ação", "RPG", "Plataforma")      | "Metroidvania"               |
| **plataforma**      | String       | Plataforma onde o jogo está disponível                 | "Steam", "PlayStation"       |
| **anoLancamento**   | int          | Ano em que foi lançado                                | 2017                         |
| **preco**           | double       | Preço do jogo em reais (R$) ou na moeda correspondente| 46.99                        |
| **classificacao**   | String       | Classificação indicativa (ex: "Livre", "18+")         | "Livre"                      |
| **nota**            | double       | Nota média do jogo (ex: avaliações, review agregadas) | 96.5                         |
| **vendas**          | int          | Quantidade de vendas/players                          | 30000000                     |
| **imagem**          | String       | URL da imagem/capa do jogo ou caminho local           | "https://..." ou "imagens/jogo.jpg" |

---

## **🛠️ Endpoints da API**

| Verbo        | Endpoint                | Descrição                           |
|--------------|-------------------------|--------------------------------------|
| **GET**      | `/api/v1/Games`         | Lista todos os jogos                 |
| **GET**      | `/api/v1/Games/{id}`    | Retorna um jogo específico pelo id   |
| **POST**     | `/api/v1/Games`         | Adiciona um novo jogo                |
| **PUT**      | `/api/v1/Games/{id}`    | Edita um jogo existente              |
| **DELETE**   | `/api/v1/Games/{id}`    | Remove um jogo pelo id               |

### Exemplo de requisição `POST` para adicionar um jogo:

```json
{
  "titulo": "Celeste",
  "desenvolvedora": "Matt Makes Games",
  "genero": "Plataforma",
  "plataforma": "Steam",
  "anoLancamento": 2018,
  "preco": 29.99,
  "classificacao": "Livre",
  "nota": 95.0,
  "vendas": 2000000,
  "imagem": "https://exemplo.com/celeste.jpg"
}
```
> O campo **id** é gerado automaticamente pelo sistema.

---
