package com.sanvalero.Laboratorio4.Services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.sanvalero.Laboratorio4.Repositories.Entities.Movie;
import com.sanvalero.Laboratorio4.Repositories.Interfaces.MovieRepository;
import com.sanvalero.Laboratorio4.Services.Models.MovieDTO;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class MovieService {
    
    @Autowired
    private MovieRepository movieRepository;
    @Autowired
    private ModelMapper modelMapper;

    public List<MovieDTO> getAll() {
        return movieRepository.findAll().stream()
        .map(x -> modelMapper.map(x, MovieDTO.class))
        .collect(Collectors.toList());
    }


    
    public Optional<MovieDTO> findById(Long ID) {
        Optional<Movie> entity = movieRepository.findById(ID);
        if (entity.isPresent()) {
            return Optional.of(modelMapper.map(entity.get(), MovieDTO.class));
        }else{

            return Optional.empty();
        }

    }

    public List<MovieDTO> findBytittle(String title){
        return movieRepository.findByTitle(title).stream().map(x -> modelMapper.map(x, MovieDTO.class)).collect(Collectors.toList());

    }


    public List<MovieDTO> findByYearr(int year){
        return movieRepository.findByYear(year).stream().map(x -> modelMapper.map(x, MovieDTO.class)).collect(Collectors.toList());

    }

    public List<MovieDTO> findByTitleOrYearr(String title, int year){
        return movieRepository.findByTitleOrYear(title, year).stream().map(x -> modelMapper.map(x, MovieDTO.class)).collect(Collectors.toList());

    }

    // CRUD

    public MovieDTO add(MovieDTO movie) {
        Movie entityToInsert = modelMapper.map(movie, Movie.class);
        Movie result = movieRepository.save(entityToInsert);
        return modelMapper.map(result, MovieDTO.class);

    }

    public MovieDTO update(Long ID, MovieDTO movie) {

        Movie entityToInsert = modelMapper.map(movie, Movie.class);
        Movie result = movieRepository.save(entityToInsert);
        return modelMapper.map(result, MovieDTO.class);
    }

    public void delete(Long ID) {
        Optional<Movie> entityToDelete = movieRepository.findById(ID);
        if (entityToDelete.isPresent()) {
            movieRepository.delete(entityToDelete.get());
        }

    }

}
