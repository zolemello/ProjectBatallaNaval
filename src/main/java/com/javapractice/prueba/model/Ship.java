package com.javapractice.prueba.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private GamePlayer gamePlayerId;


    public Ship() {
    }


    public Ship(Long id, GamePlayer gamePlayerId) {
        this.id = id;
        this.gamePlayerId = gamePlayerId;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public GamePlayer getGamePlayerId() {
        return gamePlayerId;
    }

    public void setGamePlayerId(GamePlayer gamePlayerId) {
        this.gamePlayerId = gamePlayerId;
    }

    //to String Method
    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id +
                ", gamePlayerId=" + gamePlayerId +
                '}';
    }
}
