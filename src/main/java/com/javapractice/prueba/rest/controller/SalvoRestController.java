package com.javapractice.prueba.rest.controller;

import com.javapractice.prueba.model.Salvo;
import com.javapractice.prueba.service.SalvoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

 @RequestMapping("/salvo")
 @RestController
    public class SalvoRestController {

        @Autowired
        private SalvoService salvoService;

        @GetMapping
        public List<Salvo> findall() {
            return (List<Salvo>) SalvoService.findall();
        }

        @GetMapping("/{id}")
        public Salvo findPlayerbyId(@PathVariable("id") Long id) {

            return salvoService.findbyId(id).get();
        }
    }

