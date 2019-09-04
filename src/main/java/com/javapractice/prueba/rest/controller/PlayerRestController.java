package com.javapractice.prueba.rest.controller;

import com.javapractice.prueba.model.Player;
import com.javapractice.prueba.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/player")
@RestController
public class PlayerRestController {

    @Autowired
    private PlayerService playerService;
    /*esta conectando el servicio con el controlador? */

    @GetMapping
    public List <Player> findall () {
        return playerService.findall();
    }

    @GetMapping ("/{id}") // aca le dice que cualquier cosa que vaya despues de la barra que es un id
    public Player findPlayerbyId(@PathVariable ("id") Long id) {
        //aca arriba con el PathVariable setea el id, lo que viene de la linea de arriba lo poone aca?
        return playerService.findbyId(id).get();
    }

    /*@PostMapping // esto crea ...algo VER ESTO
    public Player createPlayer(@RequestBody Player player) {
        return playerService.createPlayer();
    }*/


}
