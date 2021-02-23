package com.sanvalero.Laboratorio4.Web.View;

import com.sanvalero.Laboratorio4.Services.MovieService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("movies")
public class MoviesViewController {
    
    private final MovieService movieService;

    MoviesViewController(MovieService movieService) {

        this.movieService = movieService;
    }

    @GetMapping("listMovies")

    public ModelAndView movies() {
        ModelAndView modelo = new ModelAndView("listMovies");
        modelo.addObject("movies", movieService.getAll());
        return modelo;
    }
}
