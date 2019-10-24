package com.javapractice.prueba.repository;


import com.javapractice.prueba.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByEmail(String username);
    Optional<Player> findFirstByEmail(String username);
}
