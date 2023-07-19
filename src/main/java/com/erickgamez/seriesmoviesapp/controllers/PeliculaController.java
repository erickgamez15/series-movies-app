package com.erickgamez.seriesmoviesapp.controllers;

import com.erickgamez.seriesmoviesapp.entities.Pelicula;
import com.erickgamez.seriesmoviesapp.services.IGeneroService;
import com.erickgamez.seriesmoviesapp.services.IPeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class PeliculaController {

    private final IPeliculaService peliculaService;
    private final IGeneroService generoService;
    Pelicula pelicula;

    public PeliculaController(IPeliculaService peliculaService, IGeneroService generoService){
        this.peliculaService = peliculaService;
        this.generoService = generoService;
        pelicula = new Pelicula();
    }

    @GetMapping("/pelicula")
    public String create(Model model){
        model.addAttribute("titulo", "Nueva Película");
        model.addAttribute("pelicula", pelicula);
        return "pelicula";
    }

    @GetMapping("/pelicula/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("titulo", "Editar Película");
        model.addAttribute("genero", generoService.findAll());
        model.addAttribute("pelicula", pelicula);
        return "pelicula";
    }
}
