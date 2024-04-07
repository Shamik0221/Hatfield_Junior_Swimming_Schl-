package com.hjss.swimmingschool;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LearnerTest {

    Learner learner = null;

    @BeforeEach
    void setUp() {
        learner = new Learner("Courtney","Female",19,"+1-(421)-223232", "+1-(123)-232322", 0);
    }

    @AfterEach
    void tearDown() {
        learner = null;
    }

    @Test
    void setName() {
        String name = "Cris";
        learner.setName(name);
        assertEquals(name, learner.getName());
    }

    @Test
    void setGender() {
        String gender = "Male";
        learner.setGender(gender);
        assertEquals(gender, learner.getGender());
    }

    @Test
    void setAge() {
        int age = 21;
        learner.setAge(age);
        assertEquals(age, learner.getAge());

    }

    @Test
    void setPhone() {
        String newphone = "+1-(442)-223232";
        learner.setPhone(newphone);
        assertEquals(newphone, learner.getPhone());
    }

    @Test
    void setEmergencyContact() {
        String emergencyphone = "+1-(442)-223232";
        learner.setEmergencyContact(emergencyphone);
        assertEquals(emergencyphone, learner.getEmergencyContact());
    }

    @Test
    void setGrade() {
        int grade = 2;
        learner.setGrade(grade);
        assertEquals(grade, learner.getGrade());
    }

    @Test
    void getName() {
        learner = new Learner("Courtney","Female",19,"+1-(421)-223232", "+1-(123)-232322", 0);
    
    }

    @Test
    void getGender() {
        assertEquals("Female", learner.getGender());
    }

    @Test
    void getAge() {
        assertEquals(19, learner.getAge());
    }

    @Test
    void getPhone() {
        assertEquals("+1-(421)-223232",learner.getPhone());
    }

    @Test
    void getEmergencyContact() {
        assertEquals("+1-(123)-232322", learner.getEmergencyContact());
    }

    @Test
    void getGrade() {
        assertEquals(0, learner.getGrade());
    }

    @Test
    void bookSession() {
        TimeSlot t = new TimeSlot("Monday","3-4pm", 1);
        Session s =  new Session(t,"James",1);
        boolean status = s.addLearner(learner);
        
        // Able to add the learner to session
        assertEquals(true,status);

        // able to find session in student's bookedSession
        assertEquals(true, learner.findInBookedSession(s));
        
    }

    @Test
    void cancelSession() {

        TimeSlot t = new TimeSlot("Monday","3-4pm", 1);
        Session s =  new Session(t,"James",1);
        boolean status = s.addLearner(learner);

        // Able to add the learner to session
        assertEquals(true,status);

        learner.cancelSession(s);

        // able to find session in student's bookedSession
        assertEquals(false, learner.findInBookedSession(s));

    }

    @Test
    void updateSession() {

        TimeSlot t = new TimeSlot("Monday","3-4pm", 1);
        Session s =  new Session(t,"James",1);
        boolean status = s.addLearner(learner);

        // Able to add the learner to session
        assertEquals(true,status);

        learner.updateSession(s);

        // able to find session in student's bookedSession
        assertEquals(1, learner.getGrade());

        assertEquals(false, learner.findInBookedSession(s));
        assertEquals(true, learner.findInCompletedSession(s));
    }
}
