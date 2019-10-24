package com.javapractice.prueba.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date creationDate;

    @ManyToOne (fetch = FetchType.EAGER)
    private Player player;

    @ManyToOne (fetch = FetchType.LAZY)
    @JsonIgnore
    private Game game;

    @JoinColumn(name = "game_id")
    @OneToMany (fetch=FetchType.LAZY)
    private List<Ship> ships;

    @OneToMany (fetch=FetchType.LAZY)
    private List<Salvo> salvos;

    //Empty Constructor
    public GamePlayer() {
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public List<Ship> getShips() {
        return ships;
    }

    public void setShips(List<Ship> ships) {
        this.ships = ships;
    }

    public List<Salvo> getSalvos() {
        return salvos;
    }

    public void setSalvos(List<Salvo> salvos) {
        this.salvos = salvos;
    }

    public Map<String, Object> gamePlayerDTO() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", getId());
        dto.put("player", getPlayer().playerDTO());

        //AGREGADO PARA TAREA 5
        Score score = this.getPlayer().getScoreByGame(this.getGame());
        if (score != null)
            dto.put("score", score.getPoints());
        else
            dto.put("score", null);


        return dto;
    }
}