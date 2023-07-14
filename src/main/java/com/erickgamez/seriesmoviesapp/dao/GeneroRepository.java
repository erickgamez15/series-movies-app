package com.erickgamez.seriesmoviesapp.dao;

import com.erickgamez.seriesmoviesapp.entities.Genero;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
public class GeneroRepository implements IGeneroRepository{

    //Se encargará de manejar todas las operaciones hacia la base de datos
    @PersistenceContext
    EntityManager entityManager;

    @Override
    @Transactional
    public void save(Genero genero) {
        //Para guardar un género
        entityManager.persist(genero);
    }

    @Override
    @Transactional
    public Genero findById(Long id) {
        //Para buscar un género
        return entityManager.find(Genero.class, id);
    }
}
