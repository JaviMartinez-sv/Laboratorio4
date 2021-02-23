package com.sanvalero.Laboratorio4.Web.API;

import java.util.List;

import com.sanvalero.Laboratorio4.Services.MovieService;
import com.sanvalero.Laboratorio4.Services.Models.MovieDTO;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MoviesController {
    private final MovieService movieService;

    MoviesController(MovieService movieService) {

        this.movieService = movieService;
    }
 
    @GetMapping("/movies")
    public List<MovieDTO> Get(@RequestParam(name = "title", required = false, defaultValue = "") String title,
            @RequestParam(name = "year", required = false, defaultValue = "0") int year) {

        if (!title.equals("") && year != 0) {
            return movieService.findByTitleOrYearr(title, year);
        } else if(title.equals("") && year != 0) {

            return movieService.findByYearr(year);
        }else if(!title.equals("") && year == 0) {

            return movieService.findBytittle(title);
        }else if(title.equals("") && year == 0) {

            return movieService.getAll();
        }
        return null;
    }
}  

    
