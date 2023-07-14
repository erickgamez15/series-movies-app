package com.erickgamez.seriesmoviesapp.entities;

import com.erickgamez.seriesmoviesapp.entities.declarations.Variables;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity //Emula el comportamiento de una base de datos
@Table(name = "generos")
public class Genero extends Variables implements Serializable{

    //Get and Set ID
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
