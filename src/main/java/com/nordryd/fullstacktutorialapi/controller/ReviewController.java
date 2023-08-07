package com.nordryd.fullstacktutorialapi.controller;

import java.util.Map;

import com.nordryd.fullstacktutorialapi.entities.Review;
import com.nordryd.fullstacktutorialapi.service.ReviewService;
import com.nordryd.fullstacktutorialapi.values.Mappings;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(Mappings.API_PREFIX + "/reviews")
public class ReviewController
{
    private final ReviewService reviewService;

    public ReviewController(final ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    // can we make this cleaner? somehow identity the movie in a path param?
    @PostMapping
    @ResponseBody
    @ResponseStatus(HttpStatus.CREATED)
    public Review createReview(@RequestBody final Map<String, String> payload) {
        return reviewService.createReview(payload.get("imdbId"), payload.get("reviewContent"));
    }
}
