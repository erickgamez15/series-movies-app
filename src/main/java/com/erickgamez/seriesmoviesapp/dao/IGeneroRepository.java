package com.erickgamez.seriesmoviesapp.dao;

import com.erickgamez.seriesmoviesapp.entities.Genero;
import org.springframework.data.repository.CrudRepository;

//Interfaz que sirve para guardar en la db un género
public interface IGeneroRepository extends CrudRepository<Genero, Long> {
}
