package com.nordryd.fullstacktutorialapi.controller;

import java.util.List;
import java.util.Optional;

import com.nordryd.fullstacktutorialapi.entities.Movie;
import com.nordryd.fullstacktutorialapi.service.MovieService;
import com.nordryd.fullstacktutorialapi.values.Mappings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * API layer. This is where the application accepts requests from the outside world and returns them. This is where
 * response code mapping should occur, and the only kind of logic that should exist.
 * No other business logic should exist here.
 */
@RestController
@RequestMapping(Mappings.API_PREFIX + "/movies")
public class MovieController
{
    private final MovieService movieService;

    @Autowired
    public MovieController(final MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{imdbId}")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public Optional<Movie> getMovieById(@PathVariable final String imdbId) {
        return movieService.getMovieById(imdbId);
    }
}
