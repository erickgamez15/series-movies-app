package com.erickgamez.seriesmoviesapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

@Entity //Emula el comportamiento de una base de datos
@Table(name = "series")
public class Serie implements Serializable {

    @Id //Para que sea la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para qye la columna sea auto incremental
    private long id;

    @NotEmpty(message = "*Ingresar el nombre de una serie")
    private String name;

    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)//Agrega solo la fecha, sin la hora
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message = "*Selecciona una fecha")
    private Date releaseDate;

    @NotNull(message = "*Selecciona un género")
    @OneToOne
    private Genero genero;

    @ManyToMany
    private List<Actor> actor;

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

    //Get and Set Actor
    public List<Actor> getActor() {
        return actor;
    }

    public void setActor(List<Actor> actor) {
        this.actor = actor;
    }
}
