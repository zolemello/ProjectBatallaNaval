package com.javapractice.prueba.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;
import java.util.stream.Collectors;


@Entity

public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;

    private String lastName;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String userName;

    @NotNull
    @NotEmpty
    @Column(unique = true)
    private String email;

    private String name;

    @NotNull
    @NotEmpty
    private String password;


//private Date lastLogin;

    @OneToMany (fetch=FetchType.LAZY)
    private Set<GamePlayer> gamePlayers;

    //AGREGADO PARA LA TAREA 5
    @OneToMany(mappedBy = "player", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Score> scores = new HashSet<>();

    //Empty Constructor
    public Player() {
    }

    //Constructor with parameters
    public Player(String firstName, String lastName, String userName, Set scores) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.scores = scores;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(Set<GamePlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }

    public Set<Score> getScores() {
        return scores;
    }

    public void setScores(Set<Score> scores) {
        this.scores = scores;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    //ESTE OBTIENE LOS SCORES DE UN DETERMINADO JUEGO QUE LO BUSCA POR ID Y SI NO LO ENCENTRA DICE QUE ES NULL
    public Score getScoreByGame(Game game) {
        return this.scores.stream()
                .filter(score -> score.getGame().getId() == game.getId())
                .findFirst()
                .orElse(null);
    }

	// ESTOS OBTIENEN LOS PUNTOS POR PERDER, EMPATAR O GANAR, Y LUEGO LOS PUNTOS TOTALES
	// HACE UN FILTRO, PONE EN UNA VARIABLE EL VALOR, Y HACE UN SET EN DONDE PONE TODOS ESOS VALORES
	public Set<Score> getLoss() {
        return this.scores.stream()
                .filter(lossScore -> lossScore.getPoints() == 0)
                .collect(Collectors.toSet());
    }

    public Set<Score> getTies() {
        return this.scores.stream()
                .filter(tieScore -> tieScore.getPoints() == 1)
                .collect(Collectors.toSet());
    }

    public Set<Score> getWons() {
        return this.scores.stream()
                .filter(wonScore -> wonScore.getPoints() == 3)
                .collect(Collectors.toSet());
    }


    public Set<Score> getLosses() {
        return this.scores.stream()
                .filter(lossScore -> lossScore.getPoints() == 0)
                .collect(Collectors.toSet());
    }


    public int getTotalPoints() {
        return this.getWons().size() * 3 + getTies().size();
    }
	
	

    public Map<String, Object> playerDTO() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
		
		Integer totalWon = this.getWons().size();
        Integer totaLose = this.getLosses().size();
        Integer totalTie = this.getTies().size();
		
		dto.put("id: ", this.getId());
        dto.put("email: ", this.getUserName());
		
		dto.put("won: ", totalWon);
        dto.put("lose: ", totaLose);
        dto.put("tie: ", totalTie);
        dto.put("total: ", this.getTotalPoints());
		
		
        return dto;
    }


}