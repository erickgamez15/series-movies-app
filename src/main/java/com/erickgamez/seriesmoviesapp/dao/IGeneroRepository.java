package com.erickgamez.seriesmoviesapp.dao;

import com.erickgamez.seriesmoviesapp.entities.Genero;

//Interfaz que sirve para guardar en la db un género
public interface IGeneroRepository {
    public void save(Genero genero);
    public Genero findById(Long id);
}
