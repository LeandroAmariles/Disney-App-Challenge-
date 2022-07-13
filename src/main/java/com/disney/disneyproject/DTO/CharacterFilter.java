package com.disney.disneyproject.DTO;

import com.disney.disneyproject.entities.Character;

public class CharacterFilter {

    private String name;
    private String image;

    public CharacterFilter(){

    }

    public CharacterFilter(String name, String image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
