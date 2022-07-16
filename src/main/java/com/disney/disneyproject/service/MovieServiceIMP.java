package com.disney.disneyproject.service;

import com.disney.disneyproject.DTO.CharacterDTO;
import com.disney.disneyproject.DTO.MovieANS;
import com.disney.disneyproject.DTO.MovieDTO;
import com.disney.disneyproject.DTO.MovieFilter;
import com.disney.disneyproject.entities.Character;
import com.disney.disneyproject.entities.Movie;
import com.disney.disneyproject.exceptions.ResourceNotFoundException;
import com.disney.disneyproject.repository.CharacterRepository;
import com.disney.disneyproject.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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
    public List<MovieANS> GetMovies() {
       List<Movie> list = movieRepository.findAll();
       List<MovieANS> movieANS = list.stream().map(movie -> mapper.MappingToAns(movie)).collect(Collectors.toList());
       return movieANS;
    }

    @Override
    public List<Movie> GetMoviesByCharacterId(long characterId) {
        Character character = characterRepository.findById(characterId).orElseThrow();
        List<Movie> movies = character.getMovies();
        return movies;
    }

    @Override
    public MovieANS CreatingMovie(MovieANS movieANS) {
        Movie movie = mapper.MovieANStoEntity(movieANS);
        List<CharacterDTO> list=movieANS.getAssociateCharacters();
        List<Character> characterList = list.stream().map(characterDTO -> mapper.mappingEntity(characterDTO)).collect(Collectors.toList());
        movie.setAssociateCharacters(characterList);
        movieRepository.save(movie);
        return movieANS;
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

    @Override
    public MovieANS UpdateMovie(long idMovie, MovieDTO movieDTO) {
        Movie movie = movieRepository.findById(idMovie).orElseThrow(()-> new ResourceNotFoundException("Movie","id",idMovie));
        movie.setRating(movieDTO.getRating());
        movie.setTitle(movieDTO.getTitle());
        movie.setDate(movieDTO.getDate());
        movie.setImage(movie.getImage());
        movieRepository.save(movie);
        List<Character> characters = movie.getAssociateCharacters();
        MovieANS movieANS = mapper.MappingToAns(movie);
        movieANS.setAssociateCharacters(characters.stream().map(character -> mapper.mappingDTO(character)).collect(Collectors.toList()));
        return movieANS;
    }

    @Override
    public void DeleteMovie(long id) {
        movieRepository.deleteById(id);
    }

    @Override
    public MovieFilter findByTitle(String title) {
        Movie movie = movieRepository.findByTitle(title);
        MovieFilter movieFilter = mapper.MappingEToFilter(movie);
        return movieFilter;
    }

    @Override
    public MovieFilter findByMovieId(long id) {
        Movie movie= movieRepository.findByPkMovieId(id);
        MovieFilter movieFilter = mapper.MappingEToFilter(movie);
        return movieFilter;
    }

    @Override
    public MovieFilter findByDate(Date date) {
        Movie movie = movieRepository.findByDateEquals(date);
        MovieFilter movieFilter = mapper.MappingEToFilter(movie);
        return movieFilter;
    }

    @Override
    public MovieANS AddCharacter(long idMovie, long idCharacter, CharacterDTO characterDTO) {
        Movie movie=movieRepository.findById(idMovie).orElseThrow(()-> new ResourceNotFoundException("Movie","id",idMovie));
        List<Character> characters = movie.getAssociateCharacters();
        Character character1= mapper.mappingEntity(characterDTO);
        characters.add(character1);
        characterRepository.save(character1);
        List<CharacterDTO>  list = characters.stream().map(character -> mapper.mappingDTO(character)).collect(Collectors.toList());
        MovieANS movieANS = mapper.MappingToAns(movie);
        movieANS.setAssociateCharacters(list);
        return movieANS;
    }

    @Override
    public MovieANS DeleteCharacter(long idMovie, long idCharacter) {
        Movie movie = movieRepository.findById(idMovie).orElseThrow(()-> new ResourceNotFoundException("Movie","id",idMovie));
        List<Character> characters = movie.getAssociateCharacters();
        for (Character x:characters) {
            if(x.getPkCharacterId()==idCharacter){
                characters.remove(x);

            }
        }
        movie.setAssociateCharacters(characters);
        MovieANS movieANS = mapper.MappingToAns(movie);
        return movieANS;
    }


}
