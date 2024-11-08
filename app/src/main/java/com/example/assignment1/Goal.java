package com.example.assignment1;

public class Goal {


    private String type;           // type of goal water exercise meditation
    private int number;        //number of cups of water or min for exercise meditation
    private String intensity; // intensity None - if water   Simple Medium Intense
    private boolean isdone;

    public Goal(String type, int number, String intensity , boolean isdone) {
        this.type = type;
        this.number = number;
        this.intensity = intensity;
        this.isdone = isdone;
    }

    // Getters and Setters
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getIntensity() {
        return intensity;
    }

    public void setIntensity(String intensity) {
        this.intensity = intensity;
    }

    public boolean isIsdone() {
        return isdone;
    }

    public void setIsdone(boolean isdone) {
        this.isdone = isdone;
    }

    @Override
    public String toString() {
        String unit = (type.equals("Water")) ? "cups" : "minutes";
        return "Goal{" +
                "type='" + type + '\'' +
                ", number=" + number + " " + unit +
                ", intensity='" + intensity + '\'' +
                ", isdone=" + isdone +
                '}';
    }

}
