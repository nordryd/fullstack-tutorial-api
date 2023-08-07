package com.nordryd.fullstacktutorialapi.controller;

import java.util.List;

import com.nordryd.fullstacktutorialapi.entities.Movie;
import com.nordryd.fullstacktutorialapi.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * API layer. This is where the application accepts requests from the outside world and returns them. This is where
 * response code mapping should occur, and the only kind of logic that should exist.
 * No other business logic should exist here.
 */
@RestController
@RequestMapping("/api/v1/movies")
public class MovieController
{
    private final MovieService movieService;

    @Autowired
    public MovieController(final MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }
}
