package com.erickgamez.seriesmoviesapp.entities.declarations;

import com.erickgamez.seriesmoviesapp.entities.Actor;
import com.erickgamez.seriesmoviesapp.entities.Genero;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

public class Variables {

    //Variables Generales
    @Id //Para que sea la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para qye la columna sea auto incremental
    protected long id;
    protected String name;

    //Variables Películas/Series
    @Column(name = "release_date")
    @Temporal(TemporalType.DATE)//Agrega solo la fecha, sin la hora
    protected Date releaseDate;
    protected Genero genero;
    protected List<Actor> mainCharacters;
}
