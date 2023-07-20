package com.erickgamez.seriesmoviesapp.controllers;

import com.erickgamez.seriesmoviesapp.entities.Serie;
import com.erickgamez.seriesmoviesapp.services.IGeneroService;
import com.erickgamez.seriesmoviesapp.services.ISerieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SerieController {

    private final ISerieService serieService;
    private final IGeneroService generoService;
    Serie serie;

    public SerieController(ISerieService serieService, IGeneroService generoService){
        this.serieService = serieService;
        this.generoService = generoService;
        serie = new Serie();
    }

    @GetMapping("/serie")
    public String create(Model model){
        model.addAttribute("serie", serie);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("titulo", "Nueva Serie");
        return "serie";
    }

    @GetMapping("/serie/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("serie", serie);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("titulo", "Editar Serie");
        return "serie";
    }

    //Creación del endpoint
    @PostMapping("/serie")
    public String guardar(Serie serie){
        serieService.save(serie);
        return "redirect:index";
    }
}
