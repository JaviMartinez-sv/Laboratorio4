package com.sanvalero.Laboratorio4.Web.Config;

import com.sanvalero.Laboratorio4.Services.MovieService;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DI {
    
    @Bean
    MovieService createMovieService() {
        return new MovieService();
    }

   

    @Bean
    ModelMapper createModelMapper() {

        return new ModelMapper();
    }
}
