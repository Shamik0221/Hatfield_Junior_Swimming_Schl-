package com.hjss.swimmingschool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {

    Review r;

    @BeforeEach
    void setUp() {
        r = new Review(4, "This is the test for review");
    }

    @AfterEach
    void tearDown() {
        r = null;
    }

    @Test
    void setComment() {
        String comment =  "This is my second comment";
        r.setComment(comment);
        assertEquals("This is my second comment",r.getComment());
    }


    @Test
    void setRating() {
        int rating = 3;
        r.setRating(rating);
        assertEquals(rating, r.getRating());
    }

    @Test
    void getComment() {
        assertEquals("This is the test for review",r.getComment());

    }

    @Test
    void getRating() {
        assertEquals(4,r.getRating());

    }
}