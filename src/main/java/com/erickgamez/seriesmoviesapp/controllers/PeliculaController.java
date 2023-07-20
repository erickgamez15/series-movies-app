package com.erickgamez.seriesmoviesapp.controllers;

import com.erickgamez.seriesmoviesapp.entities.Pelicula;
import com.erickgamez.seriesmoviesapp.services.IGeneroService;
import com.erickgamez.seriesmoviesapp.services.IPeliculaService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("titulo", "Nueva Película");
        return "pelicula";
    }

    @GetMapping("/pelicula/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("titulo", "Editar Película");
        return "pelicula";
    }

    //Creación del endpoint
    @PostMapping("/pelicula")
    public String guardar(Pelicula pelicula){
        peliculaService.save(pelicula);
        return "redirect:index";
    }
}
