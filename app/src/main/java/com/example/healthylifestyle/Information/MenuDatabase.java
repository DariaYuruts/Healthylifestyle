package com.example.healthylifestyle.Information;

public class MenuDatabase {
    private String breakfast, lunch, afternoonSnack, dinner, image;

    public MenuDatabase() {}

    public MenuDatabase(String breakfast, String lunch, String afternoonSnack, String dinner, String image) {
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
