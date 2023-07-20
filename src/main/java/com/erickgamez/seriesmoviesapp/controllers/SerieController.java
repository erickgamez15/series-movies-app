package com.erickgamez.seriesmoviesapp.controllers;

import com.erickgamez.seriesmoviesapp.entities.Serie;
import com.erickgamez.seriesmoviesapp.services.IActorService;
import com.erickgamez.seriesmoviesapp.services.IGeneroService;
import com.erickgamez.seriesmoviesapp.services.ISerieService;

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
public class SerieController {

    private final ISerieService serieService;
    private final IGeneroService generoService;
    private final IActorService actorService;
    Serie serie;

    public SerieController(ISerieService serieService, IGeneroService generoService, IActorService actorService){
        this.serieService = serieService;
        this.generoService = generoService;
        this.actorService = actorService;
        serie = new Serie();
    }

    @GetMapping("/serie")
    public String create(Model model){
        model.addAttribute("serie", serie);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("actores", actorService.findAll());
        model.addAttribute("titulo", "Nueva Serie");
        return "serie";
    }

    @GetMapping("/serie/{id}")
    public String edit(@PathVariable(name = "id") Long id, Model model){
        model.addAttribute("serie", serie);
        model.addAttribute("generos", generoService.findAll());
        model.addAttribute("actores", actorService.findAll());
        model.addAttribute("titulo", "Editar Serie");
        return "serie";
    }

    //Creación del endpoint
    @PostMapping("/serie")
    public String guardar(Serie serie,  @ModelAttribute(name="ids") String ids){
        //Expresión lambda para que los ids quden en una lista del tipo: 1,2,3,4,5,..,n
        List<Long> idsActores = Arrays.stream(ids.split(",")).map(Long::parseLong).collect(Collectors.toList());

        serie.setMainCharacters(actorService.findAllById(idsActores));

        serieService.save(serie);
        return "redirect:index";
    }
}
