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
}
