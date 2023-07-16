package com.erickgamez.seriesmoviesapp.services;

import com.erickgamez.seriesmoviesapp.entities.Serie;

import java.util.List;

public interface ISerieService {
    public void save(Serie serie);
    public Serie findById(Long id);
    public void delete(Long id);
    public List<Serie> findAll();
}