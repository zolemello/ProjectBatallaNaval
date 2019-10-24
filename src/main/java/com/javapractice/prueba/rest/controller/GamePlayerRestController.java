package com.javapractice.prueba.rest.controller;


import com.javapractice.prueba.model.GamePlayer;
import com.javapractice.prueba.model.Player;
import com.javapractice.prueba.model.Salvo;
import com.javapractice.prueba.model.Ship;
import com.javapractice.prueba.repository.PlayerRepository;
import com.javapractice.prueba.service.GamePlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RequestMapping("/gameplayer")
@RestController
public class GamePlayerRestController {

    @Autowired
    private GamePlayerService gamePlayerService;

    private PlayerRepository playerRepository;
    /*esta conectando el servicio con el controlador? */


    public GamePlayerService getGamePlayerService() {
        return gamePlayerService;
    }

    public PlayerRepository getPlayerRepository() { return playerRepository;}

    public void setPlayerRepository (PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public void setGamePlayerService(GamePlayerService gamePlayerService) {
        this.gamePlayerService = gamePlayerService;
    }

    @GetMapping
    public List<GamePlayer> findall() {
        return gamePlayerService.findall();
    }

    @GetMapping("/{id}") // aca le dice que cualquier cosa que vaya despues de la barra que es un id
    public GamePlayer findPlayerbyId(@PathVariable("id") Long id) {
        //aca arriba con el PathVariable setea el id, lo que viene de la linea de arriba lo poone aca?
        return gamePlayerService.findById(id).get();
    }


    @RequestMapping("/game_view/{gamePlayerID}")
    public Map<String, Object> getGameView(@PathVariable Long gamePlayerID) {
        GamePlayer gamePlayer = gamePlayerService.findById(gamePlayerID).orElseThrow(RuntimeException::new);
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("id", gamePlayer.getGame().getId());
        dto.put("created", gamePlayer.getGame().getCreationDate());
        dto.put("gamePlayers", gamePlayerList(gamePlayer.getGame().getGamePlayers()));
        dto.put("ships", shipsList(gamePlayer.getShips()));
        dto.put("salvoes", salvoesList(gamePlayer.getSalvos()));
        dto.put("enemySalvoes", salvoesList(gamePlayer.getGame().getGamePlayers().stream()
                .filter(gp -> !gp.getId().equals(gamePlayerID)).findFirst()
                .orElseThrow(() -> new RuntimeException()).getSalvos()));
        return dto;
    }


    private List<Map> gamePlayerList(Set<GamePlayer> gamePlayers) {
        return gamePlayers.stream()
                .map(gamePlayer -> gamePlayer.gamePlayerDTO())
                .collect(Collectors.toList());
    }

    private List<Map> shipsList(List<Ship> ships) {
        return ships.stream()
                .map(ship -> ship.shipDTO())
                .collect(Collectors.toList());
    }

    private List<Map> salvoesList( List<Salvo> salvoes) {
        return salvoes.stream()
                .map(salvo -> salvo.salvoDTO())
                .collect(Collectors.toList());
    }

    private List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    @RequestMapping("/leaderboard")
    public List<Map<String,Object>> getScoreView(){
        List<Map<String,Object>> leaderboard = new ArrayList<>();
        this.getAllPlayers().forEach(player -> {
            if(!player.getScores().isEmpty()) {
                Map<String, Object> dto = new LinkedHashMap<>();
                Map<String, Object> dtoScore = new LinkedHashMap<>();
                dtoScore.put("total", player.getTotalPoints());
                dtoScore.put("won", player.getWons());
                dtoScore.put("lost", player.getLosses());
                dtoScore.put("tied", player.getTies());
                //dto.put("name",player.getEmail());
                dto.put("score",dtoScore);
                leaderboard.add(dto);
            }
        });
        return leaderboard;
    }

}


