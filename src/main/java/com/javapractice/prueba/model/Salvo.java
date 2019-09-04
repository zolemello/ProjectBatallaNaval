package com.javapractice.prueba.model;

import javax.persistence.*;

@Entity
public class Salvo {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id; //A database-generated ID, as with Ship
        @ManyToOne
        private GamePlayer gamePlayerId; // A GamePlayer
        private Integer turnNumber; //A turn number
        private String locations;  //A list of locations


        public Salvo() {
        }


        public Salvo(Long id, GamePlayer gamePlayerId, Integer turnNumber, String locations) {
            this.id = id;
            this.gamePlayerId = gamePlayerId;
            this.turnNumber = turnNumber;
            this.locations = locations;
        }

    public String getLoctions() {
        return locations;
    }

    public void setLocations(String loctions) {
        this.locations = loctions;
    }

    public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public GamePlayer getGamePlayerId() {
            return gamePlayerId;
        }

        public void setGamePlayerId(GamePlayer gamePlayerId) {
            this.gamePlayerId = gamePlayerId;
        }

        public Integer getTurnNumber() {
            return turnNumber;
        }

        public void setTurnNumber(Integer turnNumber) {
            this.turnNumber = turnNumber;
        }

        //toString Method
        @Override
        public String toString() {
            return "Salvo{" +
                    "id=" + id +
                    ", gamePlayerId=" + gamePlayerId +
                    ", turnNumber=" + turnNumber +
                    ", locations=" + locations +
                    '}';
        }
    }


