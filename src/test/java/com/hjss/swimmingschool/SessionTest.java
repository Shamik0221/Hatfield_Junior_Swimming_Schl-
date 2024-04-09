package com.hjss.swimmingschool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionTest {

    Session s;

    @BeforeEach
    void setUp() {
        TimeSlot t = new TimeSlot("Monday","3-4", 1);
        s =  new Session(t,"James",1);
    }

    @AfterEach
    void tearDown() {
        s = null;
    }

    @Test
    void setCoach() {
        String name = "Courtney";
        s.setCoach(name);
        assertEquals(name,s.getCoach());
    }

    @Test
    void getGrade() {
        assertEquals(1,s.getGrade());
    }

    @Test
    void getDay() {
        assertEquals("Monday",s.getDay());
    }

    @Test
    void getTime() {
        assertEquals("3-4",s.getTime());
    }

    @Test
    void getCoach() {
        assertEquals("James",s.getCoach());
    }

    @Test
    void addReview() {
        Review r = new Review(4, "This is the test for review");
        s.addReview(r);
        assertEquals(true,s.findReview(r));
    }

    @Test
    void addLearner() {
        Learner l = new Learner("Courtney","Female",19,"+1-(421)-223232", "+1-(123)-232322", 0);
        s.addLearner(l);
        assertEquals(true,s.findLearner(l));
    }
}