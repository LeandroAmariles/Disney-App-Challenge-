package com.disney.disneyproject.repository;

import com.disney.disneyproject.DTO.CharacterDTO;
import com.disney.disneyproject.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CharacterRepository extends JpaRepository<Character, Long> {

    public List<Character> findByName(String name);

    public List<Character> findByAge(Integer age);
}
