package com.javapractice.prueba.service;

import com.javapractice.prueba.model.GamePlayer;
import com.javapractice.prueba.repository.GamePlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GamePlayerService {
    @Autowired
    private GamePlayerRepository gamePlayerRepository;


    public Optional<GamePlayer> findbyId(Long id) {
        return gamePlayerRepository.findById(id);
    }

    public List<GamePlayer> findall() {
        return gamePlayerRepository.findAll();
    }

}

