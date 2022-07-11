package com.disney.disneyproject.repository;

import com.disney.disneyproject.entities.Character;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterRepository extends JpaRepository<Character, Long> {
}
