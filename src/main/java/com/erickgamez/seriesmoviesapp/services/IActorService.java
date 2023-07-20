package com.erickgamez.seriesmoviesapp.services;

import com.erickgamez.seriesmoviesapp.entities.Actor;

import java.util.List;

public interface IActorService {
    public List<Actor> findAll();
    public List<Actor> findAllById(List<Long> ids);
}