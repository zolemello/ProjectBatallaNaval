package com.javapractice.prueba.repository;


import com.javapractice.prueba.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource
public interface PlayerRepository extends JpaRepository <Player, Long>{
    List<Player> findByUserName(String userName);
    Optional<Player> findFirstByUserName(String userName);
}
