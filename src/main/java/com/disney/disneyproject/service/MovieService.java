package com.disney.disneyproject.service;

import com.disney.disneyproject.DTO.MovieANS;
import com.disney.disneyproject.DTO.MovieDTO;
import com.disney.disneyproject.DTO.MovieFilter;
import com.disney.disneyproject.entities.Character;
import com.disney.disneyproject.entities.Movie;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;


public interface MovieService {

    public List<MovieANS> GetMovies();

    public List<Movie> GetMoviesByCharacterId(long CharacterId);

    public MovieANS CreatingMovie(MovieANS movieANS);


    public MovieDTO AssiciatingCharacters(MovieDTO movieDTO, long characterID);

    public MovieANS GetMovieDetails(long idMovie);

    public MovieANS UpdateMovie(long movieid,MovieDTO movieDTO);

    public void DeleteMovie(long id);

    public MovieFilter findByTitle(String title);

    public MovieFilter findByMovieId(long id);

    public MovieFilter findByDate(Date date);

    public MovieANS AddOrDeleteCharacter(long idMovie, long idCharcater);

}
