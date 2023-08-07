package com.nordryd.fullstacktutorialapi.service;

import com.nordryd.fullstacktutorialapi.entities.Movie;
import com.nordryd.fullstacktutorialapi.entities.Review;
import com.nordryd.fullstacktutorialapi.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService
{
    private final ReviewRepository reviewRepository;
    // Another way to talk to the database when a repository doesn't cut it. This is for complex operations and dynamic
    // queries.
    private final MongoTemplate mongoTemplate;

    @Autowired
    public ReviewService(final ReviewRepository reviewRepository, final MongoTemplate mongoTemplate) {
        this.reviewRepository = reviewRepository;
        this.mongoTemplate = mongoTemplate;
    }

    public Review createReview(final String imdbId, final String reviewContent) {
        // .insert also returns the data you just pushed
        final Review review = reviewRepository.insert(new Review(reviewContent));

        // Find the movie that matches the given imdbId, and update it by pushing a new review.
        // .first ensures you're just updating the first match
        mongoTemplate.update(Movie.class).matching(Criteria.where("imdbId").is(imdbId))
                .apply(new Update().push("reviewIds").value(review)).first();

        return review;
    }
}
