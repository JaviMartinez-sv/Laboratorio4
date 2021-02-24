package com.sanvalero.Laboratorio4.Web.API;

import java.util.List;

import com.sanvalero.Laboratorio4.Services.MovieService;
import com.sanvalero.Laboratorio4.Services.Models.MovieDTO;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    //CRUD

    @PostMapping("/addmovies")
    public MovieDTO addMovie(@RequestBody MovieDTO newMovie) {
        for (MovieDTO movie : movieService.getAll()) {
            if (movie.getId() == newMovie.getId()) {
                return null;
            }
        }
        movieService.add(newMovie);
        return (MovieDTO) newMovie;
    }

    // Modificar pelicula
    @PutMapping("/movies/{id}")
    public MovieDTO Update(@RequestBody MovieDTO updaMovie, @PathVariable("id") Long id) {

        return movieService.update(id, updaMovie);
    }

    // borrar pelicula
    @DeleteMapping("/movies/{id}")
    public void deleMovie(@PathVariable("id") Long id) {
        movieService.delete(id);

    }

}  

    
