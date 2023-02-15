package com.example.healthylifestyle.Information;

public class Water {
    private int mc;
    private int max;
    private int day;
    private int month;
    private int year;

    public Water() {}

    public Water(int mc, int max, int day, int month, int year) {
        this.mc = mc;
        this.max = max;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getMc() { return mc; }

    public void setMc(int mc) { this.mc = mc; }

    public int getMax() { return max; }

    public void setMax(int max) { this.max = max; }

    public int getDay() { return this.day; }

    public void setDay(int day) {this.day = day; }

    public int getMonth() { return this.month; }

    public void setMonth(int month) { this.month = month; }

    public int getYear() { return this.year; }

    public void setYear(int year) { this.year = year; }
}
