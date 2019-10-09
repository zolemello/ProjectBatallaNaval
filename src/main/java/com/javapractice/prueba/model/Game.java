package com.javapractice.prueba.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Entity //Una entidad es una tabla de una base de datos.
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @NotEmpty
    //private Date creationDate;
    //Date es el tipo de dato de creationDate
    private Date creationDate;

    @JoinColumn (name="game_id")
    @OneToMany (fetch = FetchType.EAGER)
    private Set<GamePlayer> gamePlayers;


    public Game() {

    }

    public Game (Date date) {
        this.creationDate = date;
    }



    public Game(Long id, Date creationDate) {
        this.id = id;
        this.creationDate = creationDate;
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

    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(Set<GamePlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }


    /*@Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                '}';
    }*/

    public Map<String, Object> gameDTO() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        Stream<Map<String, Object>> gamePlayerDTO = getGamePlayers().stream().map(GamePlayer::gamePlayerDTO);
        //Stream<Map<String, Object>> shipDTO = getShips().stream().map(Ship::toDTO);
        dto.put("id", getId());
        dto.put("creationDate", getCreationDate());
        dto.put("gamePlayers", gamePlayerDTO.collect(toList()));
        //Obtengo el stream de gamePlayers. Lo transformo a  Stream<Set<Ship>>. Con flatMap lo transformo a un Stream<Ship> y lo
        //collecto con forma de lista.
        List<Ship> result = gamePlayers.stream().map(GamePlayer::getShips).flatMap(Collection::stream).collect(toList());
        dto.put("ships", result);
        return dto;
    }

}
