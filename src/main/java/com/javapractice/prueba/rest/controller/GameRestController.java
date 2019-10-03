package com.javapractice.prueba.rest.controller;


import com.javapractice.prueba.exception.GameNotFoundException;
import com.javapractice.prueba.model.Game;
import com.javapractice.prueba.model.GamePlayer;
import com.javapractice.prueba.repository.GamePlayerRepository;
import com.javapractice.prueba.service.GamePlayerService;
import com.javapractice.prueba.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@RequestMapping("/game")
@RestController
public class GameRestController {


    @Autowired
    private GameService gameService;
    /*esta conectando el servicio con el controlador? con esto trae los metodos del service */

    @Autowired
    private GamePlayerRepository gamePlayerRepository;

    @Autowired
    private GamePlayerService gamePlayerService;

    public GamePlayerRepository getGamePlayerRepository() {
        return gamePlayerRepository;
    }
    @GetMapping("/games")
    public List<Object> getAllGames() {
        List<Game> games = gameService.findall();
        return games.stream()
                .map(Game::toDTO)
                .collect(Collectors
                        .toList());
    }

    //@GetMapping("/ids")
    //public List<Long> findallids() {
      //  return gameService.findall().stream().map(game -> game.getId()).collect(toList());

    //}
/*
    @GetMapping {"/id"}
    public Game findGameById(@PathVariable ("id") Long id){
        return gameService.findById(id).orElseThrow(() -> new GameNotFoundException(id));
    }
*/

   public void setGamePlayerRepository(GamePlayerRepository gamePlayerRepository) {
        this.gamePlayerRepository = gamePlayerRepository;
    }


    @GetMapping
    public List<Game> findall() {
        return gameService.findall();
    }

    @GetMapping("api/{id}")
    public Map<String, Object> findGameById(@PathVariable("id") Long id) {
        Game game = gameService.findById(id).orElseThrow(() -> new GameNotFoundException(id));
        GamePlayer gamePlayer = gamePlayerService.findById(id).orElseThrow(() -> new GameNotFoundException(id));
        Map<String, Object> dto = new HashMap<>();
        dto.put("id", game.getId());
        dto.put("created", game.getCreationDate());
        dto.put("gamePlayers", game.getGamePlayers());
        dto.put("ships", gamePlayer.getShips());
        return dto;
    }

    // DE LA TAREA 3
@RequestMapping("api/game_view/{nn}")
    public Map<String, Object> getGameView(@PathVariable Long gamePlayerID) {
    Game game = gameService.findById(gamePlayerID).orElseThrow(() -> new GameNotFoundException(gamePlayerID));
        // ESTO NSTANCIA UN NUEVO JUEGO Y ME TRAE A TRAVES DEL SERVICE TODOS LOS ID QUE ME HAYAN LLLEGADO??
    GamePlayer gamePlayer = gamePlayerService.findById(gamePlayerID).orElseThrow(() -> new GameNotFoundException(gamePlayerID));

        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("id", game.getId());
        dto.put("created", game.getCreationDate());
        dto.put("GamePlayers", gamePlayer.getPlayer());
        return dto;
    }



}

