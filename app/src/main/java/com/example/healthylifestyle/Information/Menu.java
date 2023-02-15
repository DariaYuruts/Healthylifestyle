package com.example.healthylifestyle.Information;

import android.graphics.Bitmap;

public class Menu {
    private String breakfast, lunch, afternoonSnack, dinner;
    private Bitmap image;

    public Menu(String breakfast, String lunch, String afternoonSnack, String dinner, Bitmap image) {
        this.breakfast = breakfast;
        this.lunch = lunch;
        this.afternoonSnack = afternoonSnack;
        this.dinner = dinner;
        this.image = image;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getLunch() {
        return lunch;
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public String getAfternoonSnack() {
        return afternoonSnack;
    }

    public void setAfternoonSnack(String afternoonSnack) {
        this.afternoonSnack = afternoonSnack;
    }

    public String getDinner() {
        return dinner;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }
}
