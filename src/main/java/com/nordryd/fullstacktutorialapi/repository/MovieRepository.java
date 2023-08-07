package com.nordryd.fullstacktutorialapi.repository;

import com.nordryd.fullstacktutorialapi.entities.Movie;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Data layer. Any and all interactions with the db should be here. This creates a repo of Movies that have a primary
 * key of type ObjectId. No business logic should exist here.
 */
@Repository // Creates a bean of type MovieRepository
public interface MovieRepository extends MongoRepository<Movie, ObjectId>
{}
