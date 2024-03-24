package com.hjss.swimmingschool;

import java.util.UUID;

public class Review {
    public UUID  id;

    public String comments;

    public int rating;

    public Review (int rating, String comments) {
        this.id = new UUID();
        this.rating = rating;
        this.comments = comments;
    }
}
