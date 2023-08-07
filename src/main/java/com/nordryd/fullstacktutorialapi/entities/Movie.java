package com.nordryd.fullstacktutorialapi.entities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

@Document(collection = "movies") // marks class as a candidate for mapping to the db
@Data // takes care of getters, setters, and toString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Movie
{
    @Id // annotated field is treated as unique identifier
    private ObjectId id;
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> genres;
    private List<String> backdrops;
    @DocumentReference // causes only the entity Ids to be stored here and the reviews themselves stored elsewhere
    private List<Review> reviewIds; // all reviews related to the movie will be added to this list here (1:many)
}
