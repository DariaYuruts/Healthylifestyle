package com.example.healthylifestyle.Information;

public class Indexes {
    int bmi, cpfc;
    String bmiDate, cpfcDate;

    public Indexes() {}

    public Indexes(int bmi, int cpfc, String bmiDate, String cpfcDate) {
        this.bmi = bmi;
        this.cpfc = cpfc;
        this.bmiDate = bmiDate;
        this.cpfcDate = cpfcDate;
    }

    public int getBmi() { return bmi; }

    public void setBmi(int bmi) { this.bmi = bmi; }

    public String getBmiDate() { return bmiDate; }

    public void setBmiDate(String bmiDate) { this.bmiDate = bmiDate; }

    public int getCpfc() { return cpfc; }

    public void setCpfc(int cpfc) { this.cpfc = cpfc; }

    public String getCpfcDate() { return cpfcDate; }

    public void setCpfcDate(String cpfcDate) { this.cpfcDate = cpfcDate; }
}
