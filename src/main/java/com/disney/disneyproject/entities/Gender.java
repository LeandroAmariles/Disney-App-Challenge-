package com.disney.disneyproject.entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="Genders")
public class Gender {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long pkGenderId;
    private String name;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "genders")
    private List<Movie> associateMovies;

    public Gender (){

    }

    public Gender(long pkGenderId, String name, List<Movie> associateMovies) {
        this.pkGenderId = pkGenderId;
        this.name = name;
        this.associateMovies = associateMovies;
    }

    public long getPkGenderId() {
        return pkGenderId;
    }

    public void setPkGenderId(long pkGenderId) {
        this.pkGenderId = pkGenderId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getAssociateMovies() {
        return associateMovies;
    }

    public void setAssociateMovies(List<Movie> associateMovies) {
        this.associateMovies = associateMovies;
    }
}
