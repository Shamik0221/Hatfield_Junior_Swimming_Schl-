package com.hjss.swimmingschool;

import java.util.UUID;

public class Review {

    private static int sequence = 40001;
    private int id;
    public String comment;
    public int rating;

    public Review () {
        this.id = sequence++; 
        this.rating = -1; 
        this.comment = "";
    }



    public Review (int rating, String comment) {
        this.id = sequence++; 
        this.rating = rating;
        this.comment = comment;
    }

    public void setComment(String comment){
        this.comment = comment;
    }

    public void setRating(int rating) {
         this.rating = rating;
    }

    public String getComment(){
        return comment;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public String toString() {
        return comment + " " + rating;
    }

    public void printInfo() {
        System.out.println("Review Id       : " + id);
        System.out.println("Review Rating   : " + rating);
        System.out.println("Review Comments : " + comment);
    }

}
