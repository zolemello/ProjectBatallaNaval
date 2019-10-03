package com.javapractice.prueba.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date joinDate;

    @ManyToOne (fetch = FetchType.EAGER)
    private Player player;

    @ManyToOne (fetch = FetchType.LAZY)
    private Game game;

    @JoinColumn(name = "game_id")
    @OneToMany (fetch=FetchType.EAGER)
    private List<Ship> ships;

    @OneToMany (fetch=FetchType.EAGER)
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

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
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

    public Map<String, Object> toDTO() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", getId());
        dto.put("player", getPlayer().toDTO());
        return dto;
    }
}