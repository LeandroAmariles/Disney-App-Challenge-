package com.disney.disneyproject.service;

import com.disney.disneyproject.DTO.*;
import com.disney.disneyproject.entities.Character;
import com.disney.disneyproject.entities.Gender;
import com.disney.disneyproject.entities.Movie;
import org.springframework.stereotype.Service;

@Service
public class Mapper {

    public Mapper(){

    }
    public MovieDTO MappingToDTO(Movie movie){
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setPkMovieId(movie.getPkMovieId());
        movieDTO.setDate(movie.getDate());
        movieDTO.setImage(movie.getImage());
        movieDTO.setRating(movie.getRating());
        movieDTO.setTitle(movie.getTitle());

        return movieDTO;

    }
    public Movie MappingToEntity(MovieDTO movieDTO){
        Movie movie1=new Movie();
        movie1.setPkMovieId(movieDTO.getPkMovieId());
        movie1.setImage(movieDTO.getImage());
        movie1.setDate(movieDTO.getDate());
        movie1.setRating(movieDTO.getRating());
        movie1.setTitle(movieDTO.getTitle());

        return movie1;
    }
    public MovieANS MappingToAns(Movie movie){
        MovieANS movieAns = new MovieANS();
        movieAns.setPkMovieId(movie.getPkMovieId());
        movieAns.setDate(movie.getDate());
        movieAns.setImage(movie.getImage());
        movieAns.setRating(movie.getRating());
        movieAns.setTitle(movie.getTitle());
        return movieAns;
    }
    public  Movie MovieANStoEntity(MovieANS movieANS){
        Movie movie = new Movie();
        movie.setPkMovieId(movieANS.getPkMovieId());
        //movie.setGenders(movieANS.getGenders());
        movie.setTitle(movieANS.getTitle());
        movie.setRating(movieANS.getRating());
        movie.setDate(movieANS.getDate());
        movieANS.setImage(movie.getImage());
        return movie;

    }
    public GenderDTO MappingToDTO(Gender gender){
        GenderDTO genderDTO = new GenderDTO();
        genderDTO.setGenderId(gender.getPkGenderId());
        genderDTO.setName(gender.getName());

        return genderDTO;
    }

    public Gender MappingToEntity(GenderDTO genderDTO){
        Gender gender = new Gender();
        gender.setName(genderDTO.getName());
        gender.setPkGenderId(genderDTO.getGenderId());
        return gender;
    }

    public Character mappingEntity(CharacterDTO character){
        Character newCharacter = new Character();
        newCharacter.setPkCharacterId(character.getPkCharacterId());
        newCharacter.setName(character.getName());
        newCharacter.setWeiht(character.getWeight());
        newCharacter.setAge(character.getAge());
        newCharacter.setHistory(character.getHistory());
        newCharacter.setImage(character.getImage());
        return newCharacter;
    }

    public CharacterDTO mappingDTO(Character character){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setPkCharacterId(character.getPkCharacterId());
        characterDTO.setAge(character.getAge());
        characterDTO.setHistory(character.getHistory());
        characterDTO.setImage(character.getImage());
        characterDTO.setName(character.getName());
        characterDTO.setWeight(characterDTO.getWeight());
        return characterDTO;
    }

    public CharacterDTO mappingDTO(CharacterANS character){
        CharacterDTO characterDTO=new CharacterDTO();
        characterDTO.setPkCharacterId(character.getPkCharacterId());
        characterDTO.setAge(character.getAge());
        characterDTO.setWeight(character.getWeight());
        characterDTO.setName(character.getName());
        characterDTO.setImage(character.getImage());
        characterDTO.setHistory(character.getHistory());
        return characterDTO;
    }

    public Character AnsToEntity(CharacterANS character){
        Character newCharacter = new Character();
        newCharacter.setPkCharacterId(character.getPkCharacterId());
        newCharacter.setName(character.getName());
        newCharacter.setAge(character.getAge());
        newCharacter.setHistory(character.getHistory());
        newCharacter.setImage(character.getImage());
        newCharacter.setWeiht(character.getWeight());
        return newCharacter;
    }
    public CharacterANS EntirytoANS(Character character){
        CharacterANS newCharacter = new CharacterANS();
        newCharacter.setPkCharacterId(character.getPkCharacterId());
        newCharacter.setName(character.getName());
        newCharacter.setAge(character.getAge());
        newCharacter.setHistory(character.getHistory());
        newCharacter.setImage(character.getImage());
        newCharacter.setWeight(character.getWeiht());
        return newCharacter;
    }

    public CharacterFilter MappingToFilter(Character character){
        CharacterFilter characterFilter=new CharacterFilter();
        characterFilter.setName(character.getName());
        characterFilter.setImage(character.getImage());
        return characterFilter;
    }

    public MovieFilter MappingEToFilter(Movie movie){
        MovieFilter movieFilter = new MovieFilter();
        movieFilter.setDate(movie.getDate());
        movieFilter.setTituo(movie.getTitle());
        movieFilter.setImage(movie.getImage());
        return movieFilter;
    }

}
