package com.disney.disneyproject.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pkMovieId;
    private String image;
    private String title;
    private Date date;
    private int rating;
    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST,CascadeType.MERGE}, mappedBy = "movies")
    private List<Character> associateCharacters;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "gender_id")
    private Gender genders;

    public Gender getGenders() {
        return genders;
    }

    public void setGenders(Gender genders) {
        this.genders = genders;
    }

    public Movie(){

    }

    public Movie(long id, String image, String title, Date date, int rating, List<Character> associateCharacters) {
        this.pkMovieId = id;
        this.image = image;
        this.title = title;
        this.date = date;
        this.rating = rating;
        this.associateCharacters = associateCharacters;
    }

    public long getPkMovieId() {
        return pkMovieId;
    }

    public void setPkMovieId(long id) {
        this.pkMovieId = id;
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

    public List<Character> getAssociateCharacters() {
        return associateCharacters;
    }

    public void setAssociateCharacters(List<Character> associateCharacters) {
        this.associateCharacters = associateCharacters;
    }
}
