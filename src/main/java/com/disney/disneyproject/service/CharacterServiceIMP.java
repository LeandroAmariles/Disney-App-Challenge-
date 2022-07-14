package com.disney.disneyproject.service;

import com.disney.disneyproject.DTO.CharacterANS;
import com.disney.disneyproject.DTO.CharacterDTO;
import com.disney.disneyproject.DTO.CharacterFilter;
import com.disney.disneyproject.DTO.MovieDTO;
import com.disney.disneyproject.entities.Movie;
import com.disney.disneyproject.exceptions.ResourceNotFoundException;
import com.disney.disneyproject.repository.CharacterRepository;
import com.disney.disneyproject.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.disney.disneyproject.entities.Character;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CharacterServiceIMP implements CharacterService{

    @Autowired
    private CharacterRepository characterRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    public Mapper mapper;

    @Override
    public CharacterANS CreateCharcarter(CharacterANS characterANS) {
        Character character= mapper.AnsToEntity(characterANS);
        List<MovieDTO> movies = characterANS.getMovieList();
        List<Movie> moviesAdd=movies.stream().map(movieDTO -> mapper.MappingToEntity(movieDTO) ).collect(Collectors.toList());
        character.setMovies(moviesAdd);
        Character Character1=characterRepository.save(character);
        CharacterDTO characterDTO1=mapper.mappingDTO(character);
        return characterANS;

    }

    @Override
    public CharacterANS UpdateCharcter(Long characterId, CharacterDTO characterSolicited) {
        Character character = characterRepository.findById(characterId).orElseThrow(()->new ResourceNotFoundException("Character","id",characterId));
        character.setName(characterSolicited.getName());
        character.setImage(characterSolicited.getImage());
        character.setHistory(characterSolicited.getHistory());
        character.setAge(characterSolicited.getAge());
        character.setWeiht(characterSolicited.getWeight());
        characterRepository.save(character);
        List<Movie> movies = character.getMovies();
        List<MovieDTO> moviesAdd =movies.stream().map(movie -> mapper.MappingToDTO(movie)).collect(Collectors.toList());
        CharacterANS ans = mapper.EntirytoANS(character);
        ans.setMovieList(moviesAdd);
        return ans;
    }

    @Override
    public void DeleteCharacterById(Long characterId) {
        characterRepository.deleteById(characterId);
    }

    @Override
    public Set<CharacterDTO> GetCharacterList() {
        List<Character> list = characterRepository.findAll();
        Set<CharacterDTO> listDTO = list.stream().map(character -> mapper.mappingDTO(character)).collect(Collectors.toSet());
        return listDTO;
    }

    @Override
    public CharacterANS CharacterDetails(long id) {
        Character character= characterRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Character","id",id));
        List<Movie> list=character.getMovies();
        List<MovieDTO> movieDTOList = list.stream().map(movie -> mapper.MappingToDTO(movie)).collect(Collectors.toList());
        CharacterANS ans = mapper.EntirytoANS(character);
        ans.setMovieList(movieDTOList);
        return ans;
    }

    @Override
    public Set<CharacterFilter> findByName(String name) {
         Set<Character> myList = characterRepository.findByName(name);
         Set<CharacterFilter> listF = myList.stream().map(character -> mapper.MappingToFilter(character)).collect(Collectors.toSet());
         return listF;
    }

    @Override
    public Set<CharacterFilter> findByAge(int age) {
        Set<Character> mylist = characterRepository.findByAge(age);
        Set<CharacterFilter> list = mylist.stream().map(character -> mapper.MappingToFilter(character)).collect(Collectors.toSet());
        return list;
    }

    @Override
    public Set<CharacterFilter> GetCharactersFilter() {
        List<Character> characters = characterRepository.findAll();
        Set<CharacterFilter> characterFilters = characters.stream().map(character -> mapper.MappingToFilter(character)).collect(Collectors.toSet());
        return characterFilters;
    }



}
