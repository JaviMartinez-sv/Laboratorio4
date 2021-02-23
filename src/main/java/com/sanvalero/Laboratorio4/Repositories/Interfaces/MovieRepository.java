package com.sanvalero.Laboratorio4.Repositories.Interfaces;

import java.util.Collection;

import com.sanvalero.Laboratorio4.Repositories.Entities.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface MovieRepository extends JpaRepository<Movie, Long> {
  
  
  
    @Query(value = "SELECT m FROM Movie m Where title = :title")
    Collection<Movie> findByTitle(@Param("title") String title);

    @Query(value = "SELECT m FROM Movie m Where year = :year")
    Collection<Movie> findByYear(@Param("year")int year);

    @Query(value = "SELECT m FROM Movie m Where title = :title AND year =:year")
    Collection<Movie> findByTitleOrYear(@Param("title") String title, @Param("year") int year);
  
    /*
    @Query(value = "SELECT p " + " FROM Movie p " + " WHERE p.title LIKE %:title% AND p.year = :year")
    List<Movie> findMovieByTitle(

            @Param("title") String title, @Param("year") int year);
    /*
    @Query(value = "SELECT p " + " FROM Movie p " + " WHERE id= :id")
    List<Movie> findByMovieId(

            @Param("id") Long id);
    */
}

// http://localhost:9090/movies?title=0&year=2020

// @Query(value = "SELECT m FROM Movie m WHERE title LIKE %:title%")