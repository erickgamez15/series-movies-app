package com.erickgamez.seriesmoviesapp.services;

import com.erickgamez.seriesmoviesapp.entities.Pelicula;

import java.util.List;

public interface IPeliculaService {
    public void save(Pelicula pelicula);
    public Pelicula findById(Long id);
    public void delete(Long id);
    public List<Pelicula> findAll();
}
