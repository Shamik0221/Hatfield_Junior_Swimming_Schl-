package com.hjss.swimmingschool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReviewTest {

    Review r = null;

    @BeforeEach
    void setUp() {
        r = new Review("James", 4, "This is first comment");
    }

    @AfterEach
    void tearDown() {
        r =null;
    }

    @Test
    void setComment() {
        r.setComment("this is second comment");
        assertEquals("this is second comment",r.getComment());
    }

    @Test
    void setRating() {
        r.setRating(3);
        assertEquals(3,r.getRating());
    }

    @Test
    void getComment() {
        assertEquals("This is first comment",r.getComment());
    }

    @Test
    void getRating() {
        assertEquals(4,r.getRating());
    }
}