package br.com.fecaf.controller;

import br.com.fecaf.model.Game;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import tools.jackson.core.type.TypeReference;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tools.jackson.databind.ObjectMapper;

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
    public List<Game> getGames() {
        return games;
    }

}
