package com.javapractice.prueba.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Salvo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //A database-generated ID, as with Ship

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GAME_PLAYER_ID")
    private GamePlayer gamePlayer; // A GamePlayer

    private Integer turn; //A turn number

    @ElementCollection
    @Column(name = "LOCATIONS")
    @CollectionTable(name = "SALVO_LOCATIONS", joinColumns = {@JoinColumn(name = "SALVO_ID")})
    private List<String> locations;  //A list of locations


    public Salvo() {
    }


    public Salvo(Integer turn, List<String> locations) {

        this.turn = turn;
        this.locations = locations;
    }

    public List<String> getLoctions() {
        return locations;
    }

    public void setLocations(List<String> loctions) {
        this.locations = loctions;
    }

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

    public Integer getTurn() {
        return turn;
    }

    public void setTurn(Integer turn) {
        this.turn = turn;
    }

    //toString Method
    @Override
    public String toString() {
        return "Salvo{" +
                "id=" + id +
                ", gamePlayer=" + gamePlayer +
                ", turn=" + turn +
                ", locations=" + locations +
                '}';
    }


    public Map<String, Object> salvoDTO() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("turn number", this.getTurn());
        dto.put("player", this.getGamePlayer().getPlayer().getId());
        dto.put("locations", this.getLoctions());
        return dto;
    }

}


