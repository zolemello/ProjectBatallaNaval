package com.javapractice.prueba.rest.controller;


import com.javapractice.prueba.model.GamePlayer;
import com.javapractice.prueba.service.GamePlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/gameplayer")
@RestController
public class GamePlayerRestController {

    @Autowired
    private GamePlayerService gamePlayerService;
    /*esta conectando el servicio con el controlador? */

    public GamePlayerService getGamePlayerService() {
        return gamePlayerService;
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
        return gamePlayerService.findbyId(id).get();
    }

    /*@PostMapping // esto crea ...algo VER ESTO
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer();
    }
    */


}


