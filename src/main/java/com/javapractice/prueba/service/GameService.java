package com.javapractice.prueba.service;

import com.javapractice.prueba.model.Game;
import com.javapractice.prueba.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;
    public Optional<Game> findbyId(Long id) {
        return gameRepository.findById(id);
    }

    public List<Game> findall() {
        return gameRepository.findAll();
    }

}
