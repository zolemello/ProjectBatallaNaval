package com.javapractice.prueba.service;

import com.javapractice.prueba.model.Score;
import com.javapractice.prueba.repository.ScoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScoreService {
    @Autowired
    private ScoreRepository scoreRepository;

    public Optional<Score> findById(Long id) {
        return scoreRepository.findById(id);

    }


    public List<Score> findAll() {
        return scoreRepository.findAll();
    }
}

