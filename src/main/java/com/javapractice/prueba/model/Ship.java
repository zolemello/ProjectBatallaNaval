package com.javapractice.prueba.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Ship {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="gamePlayer_id")
    private GamePlayer gamePlayer;

    private String shipType;


    @ElementCollection
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<String> shipLocations = new ArrayList<>();

   /* @ElementCollection
    @Column(name = "LOCATIONS")
    @CollectionTable(name = "SHIP_LOCATIONS", joinColumns = {@JoinColumn(name = "SHIP_ID")})
    private List<String> shipLocations = new ArrayList<>();
*/

    public Ship() {
    }


    public Ship( String shipType, List <String> shipLocations) {


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

    public List<String> getShipLocations() {
        return shipLocations;
    }

    public void setShipLocations(List<String> shipLocations) {
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

