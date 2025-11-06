# API REST de Jogos de Videogame - Spring Boot

## 📋 Descrição do Projeto

Esta é uma API REST desenvolvida em Spring Boot para gerenciar um catálogo de jogos de videogame. A API permite operações CRUD (Create, Read, Update, Delete), com dados armazenados em arquivo JSON e interface web para uso fácil e visual.

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
- **Spring Web**
- **Jackson** (para manipulação de JSON)
- **Maven** (gerenciamento de dependências)

---

## 🕹️ Variáveis (Campos do Jogo)

Cada jogo é representado por um objeto com os seguintes atributos:

| Variável           | Tipo      | O que representa                                                | Exemplo                        |
|--------------------|-----------|-----------------------------------------------------------------|-------------------------------|
| **id**             | Long      | Identificador único do jogo (gerado automaticamente)            | 1                             |
| **titulo**         | String    | Nome/título do jogo                                             | "Hollow Knight"               |
| **desenvolvedora** | String    | Empresa/desenvolvedor do jogo                                   | "Team Cherry"                 |
| **genero**         | String    | Gênero do jogo (ex: "Ação", "RPG")                             | "Metroidvania"                |
| **plataforma**     | String    | Plataforma de lançamento/execução                               | "Steam", "PS4"                |
| **anoLancamento**  | int       | Ano de lançamento                                               | 2017                          |
| **preco**          | double    | Preço do jogo                                                   | 46.99                         |
| **classificacao**  | String    | Faixa etária recomendada (ex: "Livre", "16+", "18+")            | "Livre"                       |
| **nota**           | double    | Nota média do jogo (avaliação de usuários/portais)              | 9.7                           |
| **vendas**         | int       | Total de vendas/unidades ou downloads do jogo                    | 30000000                      |
| **imagem**         | String    | URL da imagem/capa do jogo ou caminho na pasta "static/imagens" | "https://exemplo.com/game.jpg"|

---

## 🚀 Step-by-Step para Construir/Executar a API

### 1. Pré-requisitos

- Java JDK 17 ou superior
- Maven instalado

### 2. Clone o repositório  
```bash
git clone https://github.com/amestc/SpringBootGamesAPI.git
```

### 3. Rode a aplicação  
```bash
mvn clean package
mvn spring-boot:run
```
**Ou via JAR gerado:**
```bash
java -jar target/SpringBootGamesAPI.jar
```

### 4. Interface Web  
Abra [http://localhost:8080/index.html](http://localhost:8080/index.html)  
Acesse os endpoints da API via [http://localhost:8080/api/v1/Games](http://localhost:8080/api/v1/Games)

---

## 📡 Endpoints da API

Todos recebem e entregam dados JSON estruturados conforme os campos acima.

| Verbo    | Endpoint                 | Descrição                               |
|----------|--------------------------|-----------------------------------------|
| GET      | `/api/v1/Games`          | Lista todos os jogos                    |
| GET      | `/api/v1/Games/{id}`     | Consulta jogo por id                    |
| POST     | `/api/v1/Games`          | Adiciona novo jogo                      |
| PUT      | `/api/v1/Games/{id}`     | Edita dados de um jogo existente        |
| DELETE   | `/api/v1/Games/{id}`     | Remove um jogo pelo id                  |

### Exemplo de JSON de jogo:
```json
{
  "id": 1,
  "titulo": "Hollow Knight",
  "desenvolvedora": "Team Cherry",
  "genero": "Metroidvania",
  "plataforma": "Steam",
  "anoLancamento": 2017,
  "preco": 46.99,
  "classificacao": "Livre",
  "nota": 100.0,
  "vendas": 30000000,
  "imagem": "https://exemplo.com/game.jpg"
}
```

---

## 💾 Dados e Persistência

- Os dados dos jogos são armazenados em um arquivo JSON:  
  `src/main/resources/data/games.json`
- Toda alteração (add, edit, delete) é salva automaticamente neste arquivo.

---

## 🖥️ Sobre o Front-end

- Interface web CRUD disponível em `/index.html`.
- Permite visualizar, adicionar, editar e excluir jogos.
- Edição só é possível após clicar em "Editar" em cada jogo; o campo de URL/caminho da imagem só aparece nesse modo para evitar mudanças acidentais.
- Pode usar imagens por URL ou arquivo local (coloque local em `src/main/resources/static/imagens/`).

---

## 🏃‍♂️ Como Executar e Testar

```bash
curl -X GET http://localhost:8080/api/v1/Games
```
Teste POST, PUT e DELETE com ferramentas como [Insomnia](https://insomnia.rest/), [Postman](https://www.postman.com/) ou com o próprio front-end web.

---

## 📝 Observações Importantes

- O campo **imagem** pode ser uma URL (ex: via internet) ou o caminho para um arquivo local presente na pasta `static/imagens`
- Para ver imagens locais, use: `/imagens/nome-do-arquivo.jpg`
- Os dados são persistidos em arquivo, não banco de dados.
- Todos os campos são obrigatórios para operação de cadastro e edição.

---

## 📦 Estrutura de Projeto

```
SpringBootGamesAPI/
├── pom.xml
├── README.md
├── src/
│   └── main/
│       ├── java/
│       │   └── br/com/fecaf/
│       │       ├── App.java
│       │       ├── model/
│       │       │   └── Game.java
│       │       ├── controller/
│       │       │   └── GameController.java
│       │       └── service/
│       │           └── GameService.java
│       └── resources/
│           └── data/
│               └── games.json
│           └── static/
│               └── index.html
```

---

## 📃 Licença

MIT

---

**Boa sorte usando, estudando e expandindo essa API! 🚀**
