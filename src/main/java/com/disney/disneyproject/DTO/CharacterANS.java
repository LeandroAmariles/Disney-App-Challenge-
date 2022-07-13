package com.disney.disneyproject.DTO;

import com.disney.disneyproject.entities.Movie;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public class CharacterANS {

    private long pkCharacterId;
    private String name;
    private String image;
    private int age;
    private double weight;
    private String history;
    private List<MovieDTO> movieList = new ArrayList<>();

    public CharacterANS(long pkCharacterId, String name, String image, int age, double weight, String history, List<MovieDTO> movieList) {
        this.pkCharacterId = pkCharacterId;
        this.name = name;
        this.image = image;
        this.age = age;
        this.weight = weight;
        this.history = history;
        this.movieList = movieList;
    }
    public CharacterANS(){

    }

    public long getPkCharacterId() {
        return pkCharacterId;
    }

    public void setPkCharacterId(long pkCharacterId) {
        this.pkCharacterId = pkCharacterId;
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

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public List<MovieDTO> getMovieList() {
        return movieList;
    }

    public void setMovieList(List<MovieDTO> movieList) {
        this.movieList = movieList;
    }
}
