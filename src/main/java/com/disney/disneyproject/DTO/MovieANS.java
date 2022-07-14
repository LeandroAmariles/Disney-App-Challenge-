package com.disney.disneyproject.DTO;

import com.disney.disneyproject.entities.Character;
import com.disney.disneyproject.entities.Gender;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

public class MovieANS {

    private long pkMovieId;
    private String image;
    private String title;
    private Date date;
    private int rating;
    private List<CharacterDTO> associateCharacters;
    private GenderDTO genders;

    public MovieANS(){

    }

    public MovieANS(long pkMovieId, String image, String title, Date date, int rating, List<CharacterDTO> associateCharacters, GenderDTO genders) {
        this.pkMovieId = pkMovieId;
        this.image = image;
        this.title = title;
        this.date = date;
        this.rating = rating;
        this.associateCharacters = associateCharacters;
        this.genders = genders;
    }

    public long getPkMovieId() {
        return pkMovieId;
    }

    public void setPkMovieId(long pkMovieId) {
        this.pkMovieId = pkMovieId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public List<CharacterDTO> getAssociateCharacters() {
        return associateCharacters;
    }

    public void setAssociateCharacters(List<CharacterDTO> associateCharacters) {
        this.associateCharacters = associateCharacters;
    }

    public GenderDTO getGenders() {
        return genders;
    }

    public void setGenders(GenderDTO genders) {
        this.genders = genders;
    }
}
