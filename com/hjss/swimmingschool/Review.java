package com.hjss.swimmingschool;

import java.util.UUID;

public class Review {
    private static int sequence = 40001;
    private int id;
    public String comments;
    public int rating;

    public Review () {
        this.id = sequence++; 
        this.rating = -1; 
        this.comments = ""; 
    }
    
    public Review (int rating, String comments) {
        this.id = sequence++; 
        this.rating = rating;
        this.comments = comments;
    }
    
    public void updateReview(int rating, String comments) {
        this.rating = rating;
        this.comments = comments;
    }

    public void printInfo() {
        System.out.println("Review Id       : " + id);
        System.out.println("Review Rating   : " + rating);
        System.out.println("Review Comments : " + comments);
    }

}
