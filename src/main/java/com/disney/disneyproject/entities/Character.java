package com.disney.disneyproject.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="characters")
public class Character {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pkCharacterId;
    private String name;
    private String image;
    private int age;
    private double weight;
    private String history;
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "characters_movies", joinColumns = {@JoinColumn(name = "pk_characterid", nullable = false)}, inverseJoinColumns = {@JoinColumn(name = "pk_movieid", nullable = false)})
    private List<Movie> movies;

    public Character(){

    }

    public Character(long id, String name, String image, int age, double weight, String history, List<Movie> movies) {
        this.pkCharacterId = id;
        this.name = name;
        this.image = image;
        this.age = age;
        this.weight = weight;
        this.history = history;

        this.movies = movies;
    }

    public long getPkCharacterId() {
        return pkCharacterId;
    }

    public void setPkCharacterId(long id) {
        this.pkCharacterId = id;
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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getWeiht() {
        return weight;
    }

    public void setWeiht(double weiht) {
        this.weight = weiht;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
