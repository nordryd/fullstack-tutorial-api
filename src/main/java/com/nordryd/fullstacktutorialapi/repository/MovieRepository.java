package com.nordryd.fullstacktutorialapi.repository;

import java.util.Optional;

import com.nordryd.fullstacktutorialapi.entities.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Data layer. Any and all interactions with the db should be here. This creates a repo of Movies that have a primary
 * key of type ObjectId. No business logic should exist here.
 * <br>
 * It won't be necessary to define something here unless it's a specific case that the extended repository
 * doesn't already provide.
 */
@Repository // Creates a bean of type MovieRepository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>
{
    // the method name alone tells Spring Mongo DB what to do
    Optional<Movie> findMovieByImdbId(String imdbId);
}
