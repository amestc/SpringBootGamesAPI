package br.com.fecaf.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import br.com.fecaf.model.Game;
import org.springframework.stereotype.Service;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    private final String filePath = "src/main/resources/games.json";
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<Game> getAllGames() {
        try {
            File file = new File(filePath);
            if (!file.exists()) return new ArrayList<>();
            return objectMapper.readValue(file, new TypeReference<List<Game>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Erro ao ler o arquivo JSON", e);
        }
    }

    public Game addGame(Game game) {
        List<Game> games = getAllGames();
        Long nextId = games.stream().mapToLong(Game::getId).max().orElse(0L) + 1;
        game.setId(nextId);
        games.add(game);
        writeGames(games);
        return game;
    }

    public Optional<Game> updateGame(Long id, Game updatedGame) {
        List<Game> games = getAllGames();
        Optional<Game> optGame = games.stream().filter(g -> g.getId().equals(id)).findFirst();
        if (optGame.isPresent()) {
            updatedGame.setId(id);
            games.set(games.indexOf(optGame.get()), updatedGame);
            writeGames(games);
        }
        return optGame;
    }

    public boolean deleteGame(Long id) {
        List<Game> games = getAllGames();
        boolean removed = games.removeIf(game -> game.getId().equals(id));
        if (removed) writeGames(games);
        return removed;
    }

    private void writeGames(List<Game> games) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), games);
        } catch (IOException e) {
            throw new RuntimeException("Erro ao escrever no arquivo JSON", e);
        }
    }
}