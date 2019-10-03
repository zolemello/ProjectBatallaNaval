package com.javapractice.prueba.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.persistence.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;


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
    private String password;

    private Date lastLogin;

    @OneToMany (fetch=FetchType.EAGER)
    private Set<GamePlayer> gamePlayers;

    //Empty Constructor
    public Player() {
    }

    //Constructor with parameters
    public Player(String firstName, String lastName, String userName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }

    //Getters and Setters
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



    //@Override
    public String getPassword() {
        return this.password;
    }

    //@Override
    public String getUsername() {
        return this.userName;
    }

    //@Override
    public boolean isAccountNonExpired() {
        return true;
    }

    //@Override
    public boolean isAccountNonLocked() {
        return true;
    }

    //@Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    //@Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Set<GamePlayer> getGamePlayers() {
        return gamePlayers;
    }

    public void setGamePlayers(Set<GamePlayer> gamePlayers) {
        this.gamePlayers = gamePlayers;
    }

    public Map<String, Object> toDTO() {
        Map<String, Object> dto = new LinkedHashMap<String, Object>();
        dto.put("id", getId());
        dto.put("email", getUserName());
        return dto;
    }

}