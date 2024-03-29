package com.javapractice.prueba.rest.controller;


import com.javapractice.prueba.exception.GameNotFoundException;
import com.javapractice.prueba.model.Game;
import com.javapractice.prueba.model.GamePlayer;
import com.javapractice.prueba.model.Ship;
import com.javapractice.prueba.repository.GamePlayerRepository;
import com.javapractice.prueba.repository.ShipRepository;
import com.javapractice.prueba.service.GamePlayerService;
import com.javapractice.prueba.service.GameService;
import com.javapractice.prueba.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private ShipRepository shipRepository;

    @Autowired
    private ShipService shipService;

    public void setGamePlayerRepository(GamePlayerRepository gamePlayerRepository) {
        this.gamePlayerRepository = gamePlayerRepository;
    }

    public ShipRepository getShipRepository() {return shipRepository;}
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
    /*
    private List<Map> shipsList(List<Ship> ships) {
        return ships.stream()
                .map(ship -> ship.shipDTO())
                .collect(Collectors.toList());
    }
*/


    @RequestMapping("/game_view/{gamePlayerId}")
    public Map<String, Object> getGameView(@PathVariable("gamePlayerId") Long gamePlayerId) {
        Game game = gameService.findById(gamePlayerId).orElse(null); //orElseThrow(() -> new GameNotFoundException(gamePlayerId));
        // ESTO NSTANCIA UN NUEVO JUEGO Y ME TRAE A TRAVES DEL SERVICE TODOS LOS ID QUE ME HAYAN LLLEGADO. CREEO.
        GamePlayer gamePlayer = gamePlayerService.findById(gamePlayerId).orElse(null);//orElseThrow(() -> new GameNotFoundException(gamePlayerId));
        Ship ship = shipService.findById(gamePlayerId).orElse(null);


        Map<String, Object> dto = new LinkedHashMap<>();

        if (gamePlayer != null) {
            dto.put("id", gamePlayer.getGame().getId());
            dto.put("created", gamePlayer.getGame().getCreationDate());
            dto.put("gamePlayer", gamePlayer.getGame().getGamePlayers().stream().map(GamePlayer::gamePlayerDTO));
            dto.put("ships", gamePlayer.getShips().stream().map(Ship::shipDTO));

             } else {
            dto.put(" ERROR ", " NOPE, NO EXISTE ESE PLAYER.  ");}

            return dto;



    }

}



