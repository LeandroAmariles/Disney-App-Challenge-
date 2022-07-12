package com.disney.disneyproject.service;

import com.disney.disneyproject.DTO.MovieDTO;
import com.disney.disneyproject.entities.Character;
import com.disney.disneyproject.entities.Movie;
import com.disney.disneyproject.repository.CharacterRepository;
import com.disney.disneyproject.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceIMP implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Override
    public List<Movie> GetMovies() {
       return movieRepository.findAll();
    }

    @Override
    public List<Movie> GetMoviesByCharacterId(long characterId) {
        Character character = characterRepository.findById(characterId).orElseThrow();
        List<Movie> movies = character.getMovies();
        return movies;
    }

    @Override
    public MovieDTO CreatingMovie(MovieDTO movieDTO) {
        Movie movie = MappingToEntity(movieDTO);
        movieRepository.save(movie);
        return movieDTO;
    }

    @Override
    public MovieDTO AssiciatingCharacters(MovieDTO movieDTO, long characterID) {
        return null;
    }

    private MovieDTO MappingToDTO(Movie movie){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setPkMovieId(movie.getPkMovieId());
        movieDTO.setDate(movie.getDate());
        movieDTO.setImage(movie.getImage());
        movieDTO.setRating(movie.getRating());
        movieDTO.setTitle(movie.getTitle());

        return movieDTO;

    }
    private Movie MappingToEntity(MovieDTO movieDTO){
        Movie movie1=new Movie();
        movie1.setPkMovieId(movieDTO.getPkMovieId());
        movie1.setImage(movieDTO.getImage());
        movie1.setDate(movieDTO.getDate());
        movie1.setRating(movieDTO.getRating());
        movie1.setTitle(movieDTO.getTitle());

        return movie1;
    }
}
