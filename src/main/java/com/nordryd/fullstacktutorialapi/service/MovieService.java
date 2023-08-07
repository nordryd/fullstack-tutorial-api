package com.nordryd.fullstacktutorialapi.service;

import java.util.List;
import java.util.Optional;

import com.nordryd.fullstacktutorialapi.entities.Movie;
import com.nordryd.fullstacktutorialapi.repository.MovieRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Business layer. This is where any and all business logic should go.
 */
@Service // creates a bean of type MovieService
public class MovieService
{
    private final MovieRepository movieRepository;

    @Autowired // Will find beans of the appropriate type and inject them for you
    public MovieService(final MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    // Gets all Movies from the repository
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> getMovieById(final String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
}
