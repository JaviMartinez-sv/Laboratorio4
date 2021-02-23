package com.sanvalero.Laboratorio4.Web.View;


import com.sanvalero.Laboratorio4.Services.MovieService;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller

public class MoviesViewController {
    
    private final MovieService movieService;

    MoviesViewController(MovieService movieService) {

        this.movieService = movieService;
    }

    // Buscador
    @GetMapping("listMovies")
    public ModelAndView movies(@RequestParam(name = "title", required = false, defaultValue = "") String title,
    @RequestParam(name = "year", required = false, defaultValue = "0") int year) {
        ModelAndView modelo = new ModelAndView("listMovies");
        if(!title.equals("") && year != 0) {
        return modelo.addObject("movies", movieService.findByTitleOrYearr(title, year));
        }else if(title.equals("") && year != 0) {
        return modelo.addObject("movies", movieService.findByYearr(year));
        }else if(!title.equals("") && year == 0){
        return modelo.addObject("movies", movieService.findBytittle(title));
        }
        return modelo;
    }


}
