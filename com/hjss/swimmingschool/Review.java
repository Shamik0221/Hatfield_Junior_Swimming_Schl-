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

    // Getters methods for Review Class
    public void setRating(int newRating) {
        this.rating = newRating;
    }

    public void setComments(String newComments){
        this.comments = newComments;
    }

    // Getters methods for Review Class
    public int getRating() {
        return this.rating;
    }

    public String getComments(){
        return this.comments;
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

    @Override
    public String toString() {
        return comments + " " + rating;
    }

    public void printInfo() {
        System.out.println("Review Id       : " + id);
        System.out.println("Review Rating   : " + rating);
        System.out.println("Review Comments : " + comments);
    }

}
