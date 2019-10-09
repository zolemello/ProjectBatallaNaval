package com.javapractice.prueba.model;

import javax.persistence.*;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

@Entity
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private GamePlayer gamePlayer;

    private String shipType;

    @ElementCollection
    private Set<String> shipLocations;



    public Ship() {
    }


    public Ship(GamePlayer gamePlayer, String shipType, Set <String> shipLocations) {

        this.gamePlayer = gamePlayer;
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

    public GamePlayer getGamePlayer() {
        return gamePlayer;
    }

    public void setGamePlayer(GamePlayer gamePlayer) {
        this.gamePlayer = gamePlayer;
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

    /*//to String Method
    @Override
    public String toString() {
        return "Ship{" +
                "id=" + id + '\n' +
                ", gamePlayer=" + gamePlayer + '\'' +
                ", shipType=" + shipType + '\'' +
                ", shipLocations=" + shipLocations + '\'' +
                '}';
    }*/


    public Map<String, Object> shipDTO(){
        Map<String, Object> dto = new LinkedHashMap<>();
        dto.put("type", this.getShipType());
        dto.put("locations", this.getShipLocations());
        return dto;
    }
}

