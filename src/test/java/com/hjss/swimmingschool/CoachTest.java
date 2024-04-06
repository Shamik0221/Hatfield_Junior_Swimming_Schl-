package com.hjss.swimmingschool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.*;

class CoachTest {

    Coach coach;

    @BeforeEach
    void setUp() {
        coach = new Coach("James", "Male", 41, "+1-(331)-623232", 11);
    }

    @AfterEach
    void tearDown() {
        coach = null;
    }

    @Test
    void setName() {
        String name = "Cris";
        coach.setName(name);
        assertEquals(name, coach.getName());
    }

    @Test
    void setGender() {
        String gender = "Female";
        coach.setGender(gender);
        assertEquals(gender, coach.getGender());
    }

    @Test
    void setAge() {
        int age = 48;
        coach.setAge(age);
        assertEquals(age, coach.getAge());
    }

    @Test
    void setPhone() {
        String phone = "+1-(331)-342323";
        coach.setPhone(phone);
        assertEquals(phone, coach.getPhone());
    }

    @Test
    void setYearOfExperience() {
        int year = 5;
        coach.setYearOfExperience(year);
        assertEquals(year, coach.getYearOfExperience());
    }

    @Test
    void getName() {
        assertEquals("James", coach.getName());
    }

    @Test
    void getGender() {
        assertEquals("Male", coach.getGender());
    }

    @Test
    void getAge() {
        assertEquals(41, coach.getAge());
    }

    @Test
    void getPhone() {
        assertEquals("+1-(331)-623232", coach.getPhone());

    }

    @Test
    void getYearOfExperience() {
        assertEquals(11, coach.getYearOfExperience());
    }

}