package com.hjss.swimmingschool;

public class Review implements java.io.Serializable {

    private static int sequence = 40001;
    private int id;
    public String comment;
    public int rating;
    public String reviewer;

    public Review () {
        this.id = sequence++; 
        this.rating = -1; 
        this.comment = "";
    }


    public Review (String reviewer, int rating, String comment) {
        this.id = sequence++;
        this.reviewer = reviewer;
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
        return comment + " " + rating + " " + reviewer;
    }

    public void printInfo() {
        System.out.println("Reviewer       : " + reviewer);
        System.out.println("Review Rating   : " + rating);
        System.out.println("Review Comments : " + comment);
    }

}
