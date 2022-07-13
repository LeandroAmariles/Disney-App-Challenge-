package com.disney.disneyproject.DTO;

import com.disney.disneyproject.entities.Movie;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

public class CharacterDTO {

    private long pkCharacterId;
    @NotEmpty
    private String name;
    private String image;
    @NotEmpty
    private int age;
    @NotEmpty
    private double weight;
    @NotEmpty
    @Size(min=15, message = "The history should be longer ")
    private String history;

    public CharacterDTO(){

    }

    public CharacterDTO(long id, String name, String image, int age, double weight, String history, List<Movie> movies) {
        this.pkCharacterId = id;
        this.name = name;
        this.image = image;
        this.age = age;
        this.weight = weight;
        this.history = history;


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


    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


}
