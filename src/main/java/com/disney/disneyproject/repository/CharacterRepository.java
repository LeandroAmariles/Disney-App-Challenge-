package com.disney.disneyproject.repository;

import com.disney.disneyproject.DTO.CharacterDTO;
import com.disney.disneyproject.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    public Set<Character> findByName(String name);

    public Set<Character> findByAge(Integer age);


}
