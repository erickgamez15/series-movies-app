package com.erickgamez.seriesmoviesapp.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity //Emula el comportamiento de una base de datos
@Table(name = "generos")
public class Genero implements Serializable{
    @Id //Para que sea la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para qye la columna sea auto incremental
    private long id;
    private String name;

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
}
