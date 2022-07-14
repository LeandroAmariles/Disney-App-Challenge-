package com.disney.disneyproject.controllers;


import com.disney.disneyproject.DTO.MovieANS;
import com.disney.disneyproject.DTO.MovieDTO;
import com.disney.disneyproject.DTO.MovieFilter;
import com.disney.disneyproject.entities.Movie;
import com.disney.disneyproject.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.disney.disneyproject.entities.Character;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/save_movie")
    public ResponseEntity<MovieANS> NewMovie(@RequestBody MovieANS movie){
        return new ResponseEntity<>(movieService.CreatingMovie(movie), HttpStatus.CREATED);
    }
    @GetMapping("/listar")
    public ResponseEntity<List<MovieANS>> GetMovies(){
        return new ResponseEntity<>(movieService.GetMovies(),HttpStatus.OK);
    }

    @GetMapping("/movie_details/{id}")
    public ResponseEntity<MovieANS> GetDetailMovie(@PathVariable long id){
        return new ResponseEntity<>(movieService.GetMovieDetails(id),HttpStatus.OK);
    }

    @PutMapping("/update_movie/{id}")
    public ResponseEntity<MovieANS> UpdateMovie(@PathVariable long id, @RequestBody MovieDTO movie){
        return new ResponseEntity<>(movieService.UpdateMovie(id,movie),HttpStatus.OK);
    }
    @DeleteMapping("/delete_movie/{id}")
    public  void DeleteMovie(@PathVariable long id){
        movieService.DeleteMovie(id);
    }
    @GetMapping("/filter_title/{title}")
    public ResponseEntity<MovieFilter> FilterByTitle(@PathVariable String title){
        return new ResponseEntity<>(movieService.findByTitle(title),HttpStatus.OK);
    }
    @GetMapping("/filter_id/{id}")
    public ResponseEntity<MovieFilter> FilterByMovieId(@PathVariable long id){
        return new ResponseEntity<>(movieService.findByMovieId(id),HttpStatus.OK);
    }
    @GetMapping("/filter_date/{date}")
    public ResponseEntity<MovieFilter> FilterByMovieDate(@PathVariable Date date){
        return new ResponseEntity<>(movieService.findByDate(date),HttpStatus.OK);
    }
}
