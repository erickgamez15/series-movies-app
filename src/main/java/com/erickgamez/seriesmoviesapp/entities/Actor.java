package com.erickgamez.seriesmoviesapp.entities;

import com.erickgamez.seriesmoviesapp.entities.declarations.Variables;
import jakarta.persistence.*;

import java.io.Serializable;

@Entity //Emula el comportamiento de una base de datos
@Table(name = "actores")
public class Actor extends Variables implements Serializable{

    @Column(name = "url_imagen") //Para otorgarle un nombre que simule estar declarada en un db real
    private String urlImage;

    //Get and Set ID
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    //Get and Set URL Image
    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
