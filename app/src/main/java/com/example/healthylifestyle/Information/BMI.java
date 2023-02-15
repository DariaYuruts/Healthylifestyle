package com.example.healthylifestyle.Information;

public class BMI {
    private int bmi;
    private String bmiDate;

    public BMI() {}

    public BMI(int bmi, String bmiDate) {
        this.bmi = bmi;
        this.bmiDate = bmiDate;
    }

    public int getBmi() { return bmi; }

    public void setBmi(int bmi) { this.bmi = bmi; }

    public String getBmiDate() { return bmiDate; }

    public void setBmiDate(String bmiDate) { this.bmiDate = bmiDate; }
}
