package com.sanvalero.Laboratorio4.Web.API;

import java.util.List;

import com.sanvalero.Laboratorio4.Services.MovieService;
import com.sanvalero.Laboratorio4.Services.Models.MovieDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {
    private final MovieService movieService;

    MoviesController(MovieService movieService) {

        this.movieService = movieService;
    }
 
    //Ejercicio3
    @GetMapping("prueba")
    public List<MovieDTO> getall(){
        return movieService.getAll();
    }

    
}
