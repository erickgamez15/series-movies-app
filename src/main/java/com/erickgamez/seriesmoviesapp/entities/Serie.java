package com.erickgamez.seriesmoviesapp.entities;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity //Emula el comportamiento de una base de datos
@Table(name = "series")
public class Serie implements Serializable {

    @Id //Para que sea la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para qye la columna sea auto incremental
    private long id;
    private String name;
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)//Agrega solo la fecha, sin la hora
    private Date releaseDate;
    private Genero genero;
    private List<Actor> mainCharacters;

    //Get and Set ID
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //Get and Set Name
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Get and Set Date
    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(Date premiereDate) {
        this.releaseDate = premiereDate;
    }

    //Get and Set Genre
    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    //Get and Set Characters
    public List<Actor> getMainCharacters() {
        return mainCharacters;
    }

    public void setMainCharacters(List<Actor> mainCharacters) {
        this.mainCharacters = mainCharacters;
    }
}
