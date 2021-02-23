package com.sanvalero.Laboratorio4.Repositories.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "Movie") 
@Entity(name = "Movie") 

public class Movie {
    
    private @Id @GeneratedValue Long id;
    private String title;
    private int year;
    private String poster;
    private String description;

    public Movie(final String title, final int year, final String poster, final String description) {
        
        
     
        this.title = title;
        this.year = year;
        this.poster = poster;
        this.description = description;
            
    }
    
    public Movie(String title) {
        this.title = title;
    }

    public Movie() {
    }
    
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getYear() {
        return year;
    }
    
    public void setYear(int year) {
        this.year = year;
    }
    
    public String getPoster() {
        return poster;
    }
    
    public void setPoster(String poster) {
        this.poster = poster;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }


}

