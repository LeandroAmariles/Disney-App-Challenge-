package com.disney.disneyproject.service;

import com.disney.disneyproject.DTO.MovieDTO;
import com.disney.disneyproject.entities.Movie;
import org.springframework.stereotype.Service;

import java.util.List;


public interface MovieService {

    public List<Movie> GetMovies();

    public List<Movie> GetMoviesByCharacterId(long CharacterId);

    public MovieDTO CreatingMovie(MovieDTO movieDTO);


    public MovieDTO AssiciatingCharacters(MovieDTO movieDTO, long characterID);
}
