package com.javapractice.prueba.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;


    @Entity
    public class Score {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
        @GenericGenerator(name = "native", strategy = "native")
        private long id;

        private Date finishDate;

        private int points;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "player_id")
        private Player player;

        @ManyToOne(fetch = FetchType.EAGER)
        @JoinColumn(name = "game_id")
        private Game game;



        public Score() {
        }

        public Score(int points, Game game, Player player, Date finishDate) {
            this.points = points;
            this.game = game;
            this.player = player;
            this.finishDate = finishDate;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public int getPoints() {
            return this.points;
        }

        public void setPoints(int points) {
            this.points = points;
        }

        public Date getFinishDate() {
            return finishDate;
        }

        public void setFinishDate(Date finishDate) {
            this.finishDate = finishDate;
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
		
		 public Map<String, Object> scoreDTO() {
        Map<String, Object> dto = new LinkedHashMap<>();

        dto.put("points", this.getPoints());
		dto.put("finish date", this.getFinishDate()); 
        return dto;
    }


     }




