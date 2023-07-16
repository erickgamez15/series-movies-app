package com.erickgamez.seriesmoviesapp.dao;

import com.erickgamez.seriesmoviesapp.entities.Serie;
import org.springframework.data.repository.CrudRepository;

public interface ISerieRepository extends CrudRepository<Serie, Long> {

}