package com.sanvalero.Laboratorio4.Repositories.Interfaces;


import com.sanvalero.Laboratorio4.Repositories.Entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;


public interface MovieRepository extends JpaRepository<Movie, Long> {
    
}
