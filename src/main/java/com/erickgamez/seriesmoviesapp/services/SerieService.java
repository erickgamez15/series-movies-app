package com.erickgamez.seriesmoviesapp.services;

import com.erickgamez.seriesmoviesapp.dao.ISerieRepository;
import com.erickgamez.seriesmoviesapp.entities.Serie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieService implements ISerieService {

     @Autowired
    private ISerieRepository serieRepository;

    @Override
    public void save(Serie serie) {
        serieRepository.save(serie);
    }

    @Override
    public Serie findById(Long id) {
        return serieRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(Long id) {
        serieRepository.deleteById(id);
    }

    @Override
    public List<Serie> findAll() {
        return (List<Serie>) serieRepository.findAll();
    }
}
