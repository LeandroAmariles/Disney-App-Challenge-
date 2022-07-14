package com.disney.disneyproject.service;

import com.disney.disneyproject.DTO.CharacterDTO;
import com.disney.disneyproject.DTO.MovieANS;
import com.disney.disneyproject.DTO.MovieDTO;
import com.disney.disneyproject.entities.Character;
import com.disney.disneyproject.entities.Movie;
import com.disney.disneyproject.exceptions.ResourceNotFoundException;
import com.disney.disneyproject.repository.CharacterRepository;
import com.disney.disneyproject.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceIMP implements MovieService{

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private Mapper mapper;

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
    public MovieDTO CreatingMovie(MovieDTO movieDTO, List<Character> characterList) {
        Movie movie = mapper.MappingToEntity(movieDTO);
        movie.setAssociateCharacters(characterList);
        movieRepository.save(movie);
        return movieDTO;
    }

    @Override
    public MovieDTO AssiciatingCharacters(MovieDTO movieDTO, long characterID) {
        return null;
    }

    @Override
    public MovieANS GetMovieDetails(long idMovie) {
        Movie movie = movieRepository.findById(idMovie).orElseThrow(()-> new ResourceNotFoundException("Movie","id",idMovie));
        List<Character> characters = movie.getAssociateCharacters();
        List<CharacterDTO> characterDTOS = characters.stream().map(character -> mapper.mappingDTO(character)).collect(Collectors.toList());
        MovieANS movieANS = mapper.MappingToAns(movie);
        movieANS.setAssociateCharacters(characterDTOS);
        return movieANS;
    }


}
