package com.nordryd.fullstacktutorialapi.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "reviews")
@Data
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
public class Review
{
    @Id
    private ObjectId id;
    private String content;

    public Review(final String content) {
        this.content = content;
    }
}
