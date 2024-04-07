package com.hjss.swimmingschool;


public class TimeSlot {


    private String day = "";
    private String time = "";
    private int weekNumber = 0;

    public TimeSlot(String day, String time, int weekNumber) {
            this.day = day;
            this.time = time;
            this.weekNumber = weekNumber;
    }

    public String getDay(){
        return this.day;
    }

    public String getTime() {
        return this.time;
    }

    public int getWeek() {
        return this.weekNumber;
    }

    @Override
    public String toString() {
        return day + " " + time + " " + weekNumber;
    }

    public void printInfo() {
        System.out.println("TimeSlot Day       : " + day);
        System.out.println("TimeSlot Time   : " + time);
        System.out.println("TimeSlot Week Number : " + weekNumber);
    }
}

