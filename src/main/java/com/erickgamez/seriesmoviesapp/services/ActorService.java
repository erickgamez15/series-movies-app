package com.erickgamez.seriesmoviesapp.services;

import com.erickgamez.seriesmoviesapp.dao.IActorRepository;
import com.erickgamez.seriesmoviesapp.entities.Actor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService implements IActorService {

    @Autowired //Inyección de la interfaz
    private IActorRepository actorRepository;

    @Override
    public List<Actor> findAll() {
        return (List<Actor>) actorRepository.findAll();
    }

    @Override
    public List<Actor> findAllById(List<Long> ids) {
        return (List<Actor>) actorRepository.findAllById(ids);
    }
}
