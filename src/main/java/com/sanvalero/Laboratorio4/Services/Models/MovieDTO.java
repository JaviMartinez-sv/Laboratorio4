package com.sanvalero.Laboratorio4.Services.Models;

public class MovieDTO {
    
    private Long id; 

	private String title;
    private int year;
    private String poster;
    private String description;

    public MovieDTO(final String _title, final int _year, final String _poster, final String _description) {
        
        
     
        this.title = _title;
        this.year = _year;
        this.poster = _poster;
        this.description = _description;
        

    }

    public MovieDTO(String titlee) {
	}

    public MovieDTO() {
    }    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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


}
