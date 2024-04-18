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
        Coach c = new Coach("James", "Male", 41, "+1-(331)-623232", 11);

        s =  new Session(t,c,1);
    }

    @AfterEach
    void tearDown() {
        s = null;
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
        //Review r = new Review(4, "This is the test for review");
        //s.addReview(r);
        //assertEquals(true,s.findReview(r));
    }

    @Test
    void addLearner() {
        Learner l = new Learner("Courtney","Female",19,"+1-(421)-223232", "+1-(123)-232322", 0);
        s.addLearner(l);
        //assertEquals(true,s.findLearner(l));
    }
}