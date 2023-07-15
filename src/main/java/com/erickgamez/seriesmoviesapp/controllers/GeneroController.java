package com.erickgamez.seriesmoviesapp.controllers;

import com.erickgamez.seriesmoviesapp.entities.Genero;
import com.erickgamez.seriesmoviesapp.services.GeneroService;
import org.springframework.web.bind.annotation.*;

@RestController
public class GeneroController {

    private final GeneroService generoService;

    public GeneroController(GeneroService generoService){
        this.generoService = generoService;
    }

    @PostMapping("genero")
    public Long saveGenre(@RequestParam String name){
        Genero genre = new Genero();
        genre.setName(name);

        generoService.save(genre);

        //Una vez que se haya guardado un nuevo género, nos devolverá el ID
        return genre.getId();
    }

    @GetMapping("genero/{id}")
    public String searchForId(@PathVariable(name = "id") Long id){
        return generoService.findById(id).getName();
    }
}
