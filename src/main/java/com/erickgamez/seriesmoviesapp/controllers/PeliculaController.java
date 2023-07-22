package com.erickgamez.seriesmoviesapp.controllers;

import com.erickgamez.seriesmoviesapp.entities.Pelicula;
import com.erickgamez.seriesmoviesapp.services.IActorService;
import com.erickgamez.seriesmoviesapp.services.IGeneroService;
import com.erickgamez.seriesmoviesapp.services.IPeliculaService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PeliculaController {

    private final IPeliculaService peliculaService;
    private final IGeneroService generoService;
    private final IActorService actorService;
    Pelicula pelicula;

    public PeliculaController(IPeliculaService peliculaService, IGeneroService generoService,IActorService actorService){
        this.peliculaService = peliculaService;
        this.generoService = generoService;
        this.actorService = actorService;
        pelicula = new Pelicula();
    }

    @GetMapping("/pelicula")
    public String create(Model model){
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("actores", actorService.findAll());
        model.addAttribute("titulo", "Nueva Película");
        return "pelicula";
    }

    @GetMapping("/pelicula/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("pelicula", pelicula);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("actores", actorService.findAll());
        model.addAttribute("titulo", "Editar Película");
        return "pelicula";
    }

    //Creación del endpoint
    @PostMapping("/pelicula")
    public String guardar(Pelicula pelicula, @ModelAttribute(name="ids") String ids){
        //Expresión lambda para que los ids quden en una lista del tipo: 1,2,3,4,5,..,n
        List<Long> idsActores = Arrays.stream(ids.split(",")).map(Long::parseLong).collect(Collectors.toList());

        pelicula.setActor(actorService.findAllById(idsActores));

        peliculaService.save(pelicula);
        
        return "redirect:index";
    }
}
