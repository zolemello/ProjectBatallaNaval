package com.javapractice.prueba.rest.controller;

import com.javapractice.prueba.model.Game;
import com.javapractice.prueba.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;
import java.util.stream.Collectors;

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

        @GetMapping ("/ids")
        public List <Long> findallids () {
            return gameService.findall().stream().map(game -> game.getId()).collect(Collectors.toList());
        }


        @GetMapping ("/{id}") // aca le dice que cualquier cosa que vaya despues de la barra que es un id
        public Game findGamebyId(@PathVariable ("id") Long id) {
            //aca arriba con el PathVariable setea el id, lo que viene de la linea de arriba lo poone aca?
            return gameService.findbyId(id).get();
        }




    }

