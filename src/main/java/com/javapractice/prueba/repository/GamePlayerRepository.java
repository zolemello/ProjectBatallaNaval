package com.javapractice.prueba.repository;

import com.javapractice.prueba.model.GamePlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GamePlayerRepository extends JpaRepository<GamePlayer, Long> {
}
