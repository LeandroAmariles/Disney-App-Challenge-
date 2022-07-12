package com.disney.disneyproject.DTO;

import com.disney.disneyproject.entities.Movie;


import java.util.List;

public class GenderDTO {


    private long GenderId;
    private String name;


    public GenderDTO(){

    }

    public GenderDTO(long genderId, String name, List<Movie> associateMovies) {
        GenderId = genderId;
        this.name = name;

    }

    public long getGenderId() {
        return GenderId;
    }

    public void setGenderId(long genderId) {
        GenderId = genderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
