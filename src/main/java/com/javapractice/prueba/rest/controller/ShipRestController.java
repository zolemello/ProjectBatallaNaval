package com.javapractice.prueba.rest.controller;


import com.javapractice.prueba.model.Ship;
import com.javapractice.prueba.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/ship")
@RestController
public class ShipRestController {
    @Autowired
    private ShipService shipService;

    @GetMapping
    public List<Ship> findAll() {
        return shipService.findAll();

    }

    @GetMapping("/{id}")
    public Ship findShipById(@PathVariable("id") Long id) {
        //return shipService.findById(id).orElseThrow(()->new RuntimeException());
        return shipService.findById(id).get();
    }
}
