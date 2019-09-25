package com.javapractice.prueba.model;

import javax.persistence.*;

import java.util.Set;

@Entity
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn
    private GamePlayer gamePlayerId;

    private String shipType;

    @ElementCollection
    private Set<String> shipLocations;



    public Ship() {
    }


    public Ship(GamePlayer gamePlayerId, String shipType, Set <String> shipLocations) {

        this.gamePlayerId = gamePlayerId;
        this.shipType = shipType;
        this.shipLocations = shipLocations;
    }


  //GETTERS Y SETTERS

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

    public String getShipType() {
        return shipType;
    }

    public void setShipType(String shipType) {
        this.shipType = shipType;
    }

    public Set<String> getShipLocations() {
        return shipLocations;
    }

    public void setShipLocations(Set<String> shipLocations) {
        this.shipLocations = shipLocations;
    }

    //to String Method
    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id + '\n' +
                ", gamePlayerId=" + gamePlayerId + '\'' +
                ", shipType=" + shipType + '\'' +
                ", shipLocations=" + shipLocations + '\'' +
                '}';
    }
}

