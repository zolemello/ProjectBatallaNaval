package com.javapractice.prueba.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
public class GamePlayer {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @NotNull
        @NotEmpty
        private Date creationDate;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name="player_id")
        private Player player;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name="game_id")
        private Game game;
//Esta parte es para conectar con el id de game y de player

     // A game player has a set of ships.
     //gamePlayer.getShips() should return a Set of ships

        @OneToMany(fetch=FetchType.EAGER)
        private Set<Ship> ships = new HashSet<>();


    public GamePlayer() {

    }


    public GamePlayer(Long id, Date creationDate, Player player, Game game, Set<Ship> ships) {
        this.id = id;
        this.creationDate = creationDate;
        this.player = player;
        this.game = game;
        this.ships = ships;
    }

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

    public Set<Ship> getShips() {
        return ships;
    }

    public void setShips(Set<Ship> ships) {
        this.ships = ships;
    }

    @Override
    public String toString() {
        return "Game{" +
                "id=" + id + '\'' +
                ", creationDate=" + creationDate + '\'' +
                ", player=" + player + '\'' +
                ", game=" + game + '\'' +
                '}';
    }
}
