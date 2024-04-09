package com.hjss.swimmingschool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TimeSlotTest {

    TimeSlot t;

    @BeforeEach
    void setUp() {
        t = new TimeSlot("Monday","3-4", 2);
    }

    @AfterEach
    void tearDown() {
        t = null;
    }

    @Test
    void getDay() {
        assertEquals("Monday",t.getDay());
    }

    @Test
    void getTime() {
        assertEquals("3-4",t.getTime());
    }

    @Test
    void getWeek() {
        assertEquals(2,t.getWeek());
    }
}