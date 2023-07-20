package com.erickgamez.seriesmoviesapp.dao;

import org.springframework.data.repository.CrudRepository;

import com.erickgamez.seriesmoviesapp.entities.Actor;

public interface IActorRepository extends CrudRepository<Actor, Long>{
    
}
