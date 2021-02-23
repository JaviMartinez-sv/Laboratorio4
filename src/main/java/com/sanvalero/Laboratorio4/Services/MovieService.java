package com.sanvalero.Laboratorio4.Services;

import java.util.List;
import java.util.stream.Collectors;


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

}
