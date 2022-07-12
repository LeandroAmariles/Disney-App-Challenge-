package com.disney.disneyproject.controllers;


import com.disney.disneyproject.DTO.MovieDTO;
import com.disney.disneyproject.entities.Movie;
import com.disney.disneyproject.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/guardar")
    public ResponseEntity<MovieDTO> NewMovie(@RequestBody MovieDTO movie){
        return new ResponseEntity<>(movieService.CreatingMovie(movie), HttpStatus.OK);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<Movie>> GetMovies(){
        return new ResponseEntity<>(movieService.GetMovies(),HttpStatus.OK);
    }


}
