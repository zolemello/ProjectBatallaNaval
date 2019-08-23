package com.javapractice.prueba.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    @NotEmpty
    private Date creationDate;
    //Date es el tipo de dato de creationDate


    public Game() {
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


    @Override
    public String toString() {
        return "Game{" +
                "id=" + id +
                ", creationDate=" + creationDate +
                '}';
    }
}
