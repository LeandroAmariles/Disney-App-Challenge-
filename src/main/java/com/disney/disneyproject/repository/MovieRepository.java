package com.disney.disneyproject.repository;

import com.disney.disneyproject.DTO.MovieFilter;
import com.disney.disneyproject.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {

    public Movie findByTitle(String title);

    public Movie findByPkMovieId(long id);

    public Movie findByDateEquals(Date date);

}
