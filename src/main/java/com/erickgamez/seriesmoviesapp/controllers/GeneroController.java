package com.erickgamez.seriesmoviesapp.controllers;

import com.erickgamez.seriesmoviesapp.dao.IGeneroRepository;
import com.erickgamez.seriesmoviesapp.entities.Genero;
import org.springframework.web.bind.annotation.*;

@RestController
public class GeneroController {

    private IGeneroRepository genreRepository;
    public GeneroController(IGeneroRepository generoRepository){
        this.genreRepository = generoRepository;
    }

    @PostMapping("genero")
    public Long saveGenre(@RequestParam String genreName){
        Genero genre = new Genero();
        genre.setName(genreName);
        genreRepository.save(genre);

        //Una vez que se haya guardado un nuevo género, nos devolvera el ID
        return genre.getId();
    }

    @GetMapping("genero/{id}")
    public String searchForId(@PathVariable(name = "id") long id){
        return genreRepository.findById(id).getName();
    }
}
