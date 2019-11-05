package com.javapractice.prueba.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.*;

@Entity
public class GamePlayer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native")
    private Long id;

    private LocalDateTime creationDate;

    @JsonIgnore
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "player_id")
    private Player player;

    @JsonIgnore
    @ManyToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "game_id")
    private Game game;

   /* @JoinColumn(name = "game_id")
    @OneToMany (fetch=FetchType.LAZY)
    private List<Ship> ships;

    @OneToMany (fetch=FetchType.LAZY)
    private List<Salvo> salvos;
*/

    @OneToMany(mappedBy = "gamePlayer", cascade = CascadeType.ALL)
    private List<Ship> ships = new ArrayList<>();

    @OneToMany(mappedBy = "gamePlayer", cascade = CascadeType.ALL)
    private List<Salvo> salvos = new ArrayList<Salvo>();


    //Empty Constructor
    public GamePlayer() {
    }

    public GamePlayer(Game game, Player player, LocalDateTime creationDate) {
        this.game = game;
        this.player = player;
        this.creationDate = creationDate;
    }

    //Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
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

    //METODOS
    public void addShip(Ship ship) {
        this.ships.add(ship);
        ship.setGamePlayer(this);
    }

    public void addSalvo(Salvo salvo) {
        this.salvos.add(salvo);
        salvo.setGamePlayer(this);
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