package com.hjss.swimmingschool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SessionManagerTest {

    SessionManager s ;

    @BeforeEach
    void setUp() {
        s = new SessionManager();
    }

    @AfterEach
    void tearDown() {
        s = null;
    }

    @Test
    void isValidSlot() {
        String day = "Wednesday";
        String time = "3";
        int weekNumber = 4;
        assertEquals(false,s.isValidSlot(day,time,weekNumber));
    }

    @Test
    void registerLearner() {
    }

    @Test
    void registerCoach() {
    }

    @Test
    void bookSession() {
    }

    @Test
    void cancelSession() {
    }

    @Test
    void changeSession() {
    }

    @Test
    void writeReview() {
    }
}