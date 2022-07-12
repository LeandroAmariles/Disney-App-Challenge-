package com.disney.disneyproject.service;

import com.disney.disneyproject.DTO.CharacterDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;


public interface CharacterService {

    public CharacterDTO CreateCharcarter(CharacterDTO Character);

    public CharacterDTO UpdateCharcter(Long characterId, CharacterDTO characterSolicited);

    public void DeleteCharacterById(Long characterId);

    public Set<CharacterDTO> GetCharacterList();

    public CharacterDTO CharacterDetails(long id);
}
