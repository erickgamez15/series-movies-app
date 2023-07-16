package com.erickgamez.seriesmoviesapp.controllers;

import com.erickgamez.seriesmoviesapp.entities.Serie;
import com.erickgamez.seriesmoviesapp.services.ISerieService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SerieController {

    private final ISerieService serieService;
    Serie serie;

    public SerieController(ISerieService serieService){
        this.serieService = serieService;
        serie = new Serie();
    }

    @GetMapping("/serie")
    public String create(Model model){
        model.addAttribute("titulo", "Nueva Serie");
        model.addAttribute("serie", serie);
        return "serie";
    }

    @GetMapping("/serie/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("titulo", "Editar Serie");
        model.addAttribute("serie", serie);
        return "serie";
    }
}
