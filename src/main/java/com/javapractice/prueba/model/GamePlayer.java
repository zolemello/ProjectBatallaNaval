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
}
