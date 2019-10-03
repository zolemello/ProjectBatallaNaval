package com.javapractice.prueba.service;


import com.javapractice.prueba.model.Ship;
import com.javapractice.prueba.repository.ShipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ShipService {

    @Autowired
    private ShipRepository shipRepository;

    public Optional<Ship> findById(Long id) {
        return shipRepository.findById(id);

    }


    public List<Ship> findAll() {
        return shipRepository.findAll();
    }
}