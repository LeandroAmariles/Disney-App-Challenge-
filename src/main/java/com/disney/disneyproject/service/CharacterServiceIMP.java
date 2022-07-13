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
    private MovieServiceIMP movieServiceIMP;

    @Override
    public CharacterANS CreateCharcarter(CharacterANS characterANS) {
        Character character= AnsToEntity(characterANS);
        List<MovieDTO> movies = characterANS.getMovieList();
        List<Movie> moviesAdd=movies.stream().map(movieDTO -> movieServiceIMP.MappingToEntity(movieDTO) ).collect(Collectors.toList());
        character.setMovies(moviesAdd);
        Character Character1=characterRepository.save(character);
        CharacterDTO characterDTO1=mappingDTO(character);
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
        List<MovieDTO> moviesAdd =movies.stream().map(movie -> movieServiceIMP.MappingToDTO(movie)).collect(Collectors.toList());
        CharacterANS ans = EntirytoANS(character);
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
        Set<CharacterDTO> listDTO = list.stream().map(character -> mappingDTO(character)).collect(Collectors.toSet());
        return listDTO;
    }

    @Override
    public CharacterANS CharacterDetails(long id) {
        Character character= characterRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Character","id",id));
        List<Movie> list=character.getMovies();
        List<MovieDTO> movieDTOList = list.stream().map(movie -> movieServiceIMP.MappingToDTO(movie)).collect(Collectors.toList());
        CharacterANS ans = EntirytoANS(character);
        ans.setMovieList(movieDTOList);
        return ans;
    }

    @Override
    public List<CharacterFilter> findByName(String name) {
         List<Character> myList = characterRepository.findByName(name);
         List<CharacterFilter> listF = myList.stream().map(character -> MappingToFilter(character)).collect(Collectors.toList());
         return listF;
    }

    @Override
    public List<CharacterDTO> findByAge(int age) {
        List<Character> mylist = characterRepository.findByAge(age);
        List<CharacterDTO> list = mylist.stream().map(character -> mappingDTO(character)).collect(Collectors.toList());
        return list;
    }


    private Character mappingEntity(CharacterDTO character){
        Character newCharacter = new Character();
        newCharacter.setPkCharacterId(character.getPkCharacterId());
        newCharacter.setName(character.getName());
        newCharacter.setWeiht(character.getWeight());
        newCharacter.setAge(character.getAge());
        newCharacter.setHistory(character.getHistory());
        newCharacter.setImage(character.getImage());
        return newCharacter;
    }

    private CharacterDTO mappingDTO(Character character){
        CharacterDTO characterDTO = new CharacterDTO();
        characterDTO.setPkCharacterId(character.getPkCharacterId());
        characterDTO.setAge(character.getAge());
        characterDTO.setHistory(character.getHistory());
        characterDTO.setImage(character.getImage());
        characterDTO.setName(character.getName());
        characterDTO.setWeight(characterDTO.getWeight());
        return characterDTO;
    }

    private CharacterDTO mappingDTO(CharacterANS character){
        CharacterDTO characterDTO=new CharacterDTO();
        characterDTO.setPkCharacterId(character.getPkCharacterId());
        characterDTO.setAge(character.getAge());
        characterDTO.setWeight(character.getWeight());
        characterDTO.setName(character.getName());
        characterDTO.setImage(character.getImage());
        characterDTO.setHistory(character.getHistory());
        return characterDTO;
    }

    private Character AnsToEntity(CharacterANS character){
        Character newCharacter = new Character();
        newCharacter.setPkCharacterId(character.getPkCharacterId());
        newCharacter.setName(character.getName());
        newCharacter.setAge(character.getAge());
        newCharacter.setHistory(character.getHistory());
        newCharacter.setImage(character.getImage());
        newCharacter.setWeiht(character.getWeight());
        return newCharacter;
    }
    private CharacterANS EntirytoANS(Character character){
        CharacterANS newCharacter = new CharacterANS();
        newCharacter.setPkCharacterId(character.getPkCharacterId());
        newCharacter.setName(character.getName());
        newCharacter.setAge(character.getAge());
        newCharacter.setHistory(character.getHistory());
        newCharacter.setImage(character.getImage());
        newCharacter.setWeight(character.getWeiht());
        return newCharacter;
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

    private CharacterFilter MappingToFilter(Character character){
        CharacterFilter characterFilter=new CharacterFilter();
        characterFilter.setName(character.getName());
        characterFilter.setImage(character.getImage());
        return characterFilter;
    }


}
