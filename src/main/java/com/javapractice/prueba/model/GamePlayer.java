package com.javapractice.prueba.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

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


    public GamePlayer() {

    }


    public GamePlayer(Long id, Date creationDate, Player player, Game game) {
        this.id = id;
        this.creationDate = creationDate;
        this.player = player;
        this.game = game;
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
