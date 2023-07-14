package com.erickgamez.seriesmoviesapp.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity //Emula el comportamiento de una base de datos
@Table(name = "actores")
public class Actor implements Serializable{

    @Id //Para que sea la primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para qye la columna sea auto incremental
    private long id;
    private String name;
    @Column(name = "url_imagen") //Para otorgarle un nombre que simule estar declarada en un db real
    private String urlImage;

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

    //Get and Set URL Image
    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
