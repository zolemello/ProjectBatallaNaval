package com.javapractice.prueba.rest.controller;

import com.javapractice.prueba.model.Game;
import com.javapractice.prueba.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RequestMapping("/game")
@RestController
public class GameRestController {


        @Autowired
        private GameService gameService;
        /*esta conectando el servicio con el controlador? */

        @GetMapping
        public List <Game> findall () {
            return gameService.findall();
        }

        @GetMapping ("/{id}") // aca le dice que cualquier cosa que vaya despues de la barra que es un id
        public Game findGamebyId(@PathVariable ("id") Long id) {
            //aca arriba con el PathVariable setea el id, lo que viene de la linea de arriba lo poone aca?
            return gameService.findbyId(id).get();
        }

    }

   /* @Autowired
    private GameService gameService;

    @GetMapping
    public List<Game> findall() {
        return gameService.findall();
    }

    @GetMapping("/{id}")
    public Game findPlayerbyId(@PathVariable("id") Long id) {

        return gameService.findbyId(id).get();
    }

    // en los controllers tengo la informacion, aca deberia  tener los juegos
}
*/