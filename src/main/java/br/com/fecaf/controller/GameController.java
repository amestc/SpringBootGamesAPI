package br.com.fecaf.controller;

import br.com.fecaf.model.Game;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Games")
@CrossOrigin(origins = "*", allowedHeaders = "*")

public class GameController {

    private List<Game> games = new ArrayList<>();


    @PostConstruct
    public void carregarJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass()
                    .getResourceAsStream("/data/games.json");

            games = mapper.readValue(inputStream, new TypeReference<List<Game>>() {});
            System.out.println("✅ JSON de games carregado com sucesso: " + games.size() + " games.");
        } catch (Exception e) {
            System.err.println("❌ Erro ao carregar o JSON de games: " + e.getMessage());
        }
    }
    @GetMapping
    public List<Game> listarGames() { return games; }

    @GetMapping("/{id}")
    public Game getGameById(@PathVariable int id) {
        return games.stream().filter(g -> g.getId() == id).findFirst().orElse(null);
    }

    @PostMapping
    public Game addGame(@RequestBody Game newGame) {
        Long nextId = games.stream().mapToLong(Game::getId).max().orElse(0) + 1;
        newGame.setId(nextId);
        games.add(newGame);
        salvarJson();
        return newGame;
    }

    @PutMapping("/{id}")
    public Game updateGame(@PathVariable Long id, @RequestBody Game updatedGame) {
        for (int i = 0; i < games.size(); i++) {
            if (games.get(i).getId().equals(id)) {
                updatedGame.setId(id);
                games.set(i, updatedGame);
                salvarJson();
                return updatedGame;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteGame(@PathVariable int id) {
        boolean removed = games.removeIf(g -> g.getId() == id);
        if (removed) salvarJson();
        return removed ? "Removido com sucesso!" : "Game não encontrado!";
    }

    private void salvarJson() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/resources/data/games.json"), games);
            System.out.println("✅ JSON atualizado e salvo.");
        } catch (Exception e) {
            System.err.println("❌ Erro ao salvar o JSON: " + e.getMessage());
        }
    }
}