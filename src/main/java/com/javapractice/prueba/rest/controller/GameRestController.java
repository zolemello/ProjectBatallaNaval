package com.javapractice.prueba.rest.controller;


import com.javapractice.prueba.exception.GameNotFoundException;
import com.javapractice.prueba.model.Game;
import com.javapractice.prueba.model.GamePlayer;
import com.javapractice.prueba.model.Ship;
import com.javapractice.prueba.repository.GamePlayerRepository;
import com.javapractice.prueba.service.GamePlayerService;
import com.javapractice.prueba.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    public void setGamePlayerRepository(GamePlayerRepository gamePlayerRepository) {
        this.gamePlayerRepository = gamePlayerRepository;
    }

    public GamePlayerRepository getGamePlayerRepository() {
        return gamePlayerRepository;
    }

    @GetMapping("/allgames")
    public List<Object> getAllGames() {
        List<Game> games = gameService.findall();
        return games.stream()
                .map(Game::gameDTO)
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


    @GetMapping
    public List<Game> findall() {
        return gameService.findall();
    }

    @GetMapping("/{id}")
    public Map<String, Object> findGameById(@PathVariable("id") Long id) {
        Game game = gameService.findById(id).orElseThrow(() -> new GameNotFoundException(id));
        Map<String, Object> dto = new HashMap<>();
        dto.put("id", game.getId());
        dto.put("created", game.getCreationDate());
        dto.put("gamePlayers", game.getGamePlayers());

        return dto;
    }

    // DE LA TAREA 3
    @RequestMapping("/game_view/{gamePlayerId}")
    public Map<String, Object> getGameView(@PathVariable("gamePlayerId") Long gamePlayerId) {
        Game game = gameService.findById(gamePlayerId).orElse(null); //orElseThrow(() -> new GameNotFoundException(gamePlayerId));
        // ESTO NSTANCIA UN NUEVO JUEGO Y ME TRAE A TRAVES DEL SERVICE TODOS LOS ID QUE ME HAYAN LLLEGADO. CREEO.
        GamePlayer gamePlayer = gamePlayerService.findById(gamePlayerId).orElse(null);//orElseThrow(() -> new GameNotFoundException(gamePlayerId));

        Map<String, Object> dto = new LinkedHashMap<>();

        if (gamePlayer != null) {
            dto.put("id", gamePlayer.getGame().getId());
            dto.put("created", gamePlayer.getGame().getCreationDate());
            dto.put("gamePlayer", gamePlayer.getGame().getGamePlayers().stream().map(GamePlayer::gamePlayerDTO));
            dto.put("ships", gamePlayer.getShips().stream().map(Ship::shipDTO));
            //return dto;
        } else {
            dto.put("ERROR", "NOPE, NO EXISTE ESE PLAYER.  ");}

            return dto;



    }

}



