package com.disney.disneyproject.repository;

import com.disney.disneyproject.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
}
