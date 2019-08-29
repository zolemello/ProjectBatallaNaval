package com.javapractice.prueba.service;

import com.javapractice.prueba.model.Salvo;
import com.javapractice.prueba.repository.SalvoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;



@Service
    public class SalvoService {

      @Autowired
      private SalvoRepository salvoRepository;

       public Optional<Salvo> findbyId(Long id) {
            return salvoRepository.findById(id);
        }

      public List<Salvo> findall() {
            return salvoRepository.findAll();
        }
    }


