package com.erickgamez.seriesmoviesapp.dao;

import com.erickgamez.seriesmoviesapp.entities.Pelicula;
import org.springframework.data.repository.CrudRepository;

public interface IPeliculaRepository extends CrudRepository<Pelicula, Long> {

}
