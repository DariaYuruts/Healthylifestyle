package com.example.healthylifestyle.Information;

public class ExerciseDatabase {
    private String text, name, number, image;

    public ExerciseDatabase() {}

    public ExerciseDatabase(String name, String text, String number, String image) {
        this.text = text;
        this.name = name;
        this.number = number;
        this.image = image;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
