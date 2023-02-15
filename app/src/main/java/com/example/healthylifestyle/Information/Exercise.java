package com.example.healthylifestyle.Information;

import android.graphics.Bitmap;

public class Exercise {
    private String text;
    private String name;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    private String number;
    private Bitmap image;


    public Exercise(String name, String text, String number, Bitmap image) {
        this.text = text;
        this.image = image;
        this.name = name;
        this.number = number;
    }

    public Exercise() {
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
