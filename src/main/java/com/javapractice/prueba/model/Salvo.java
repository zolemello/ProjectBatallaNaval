package com.javapractice.prueba.model;

import javax.persistence.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Entity
public class Salvo {


        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id; //A database-generated ID, as with Ship

       @ManyToOne(fetch = FetchType.EAGER)
       @JoinColumn(name = "gamePlayer_id")
        private GamePlayer gamePlayerId; // A GamePlayer

        private Integer turn; //A turn number

        @ElementCollection
        @Column(name = "location")
        private List<String> locations;  //A list of locations


        public Salvo() {
        }


        public Salvo(Long id, GamePlayer gamePlayerId, Integer turn, List <String> locations) {
            this.id = id;
            this.gamePlayerId = gamePlayerId;
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

        public GamePlayer getGamePlayerId() {
            return gamePlayerId;
        }

        public void setGamePlayerId(GamePlayer gamePlayerId) {
            this.gamePlayerId = gamePlayerId;
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
                    ", gamePlayerId=" + gamePlayerId +
                    ", turn=" + turn +
                    ", locations=" + locations +
                    '}';
        }


    public Map<String, Object> salvoDTO() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("turn number", this.getTurn());
        dto.put("player", this.getGamePlayerId().getPlayer().getId());
        dto.put("locations", this.getLoctions());
        return dto;
    }

}


