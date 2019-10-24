package com.javapractice.prueba.service;

import com.javapractice.prueba.model.Player;
import com.javapractice.prueba.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Player player = playerRepository.findFirstByUserName(username).orElseThrow(() -> new UsernameNotFoundException(username));
        //Envio el email del player, el password y envio los permisos que tiene vacios por ahora
        return new User(player.getUserName(), player.getPassword(), Collections.emptyList());
    }
}