package com.example.healthylifestyle.Information;

public class User {
    private String name, surname, email, pass, age, heightInput, weightInput, sex;


    public User() {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.pass = pass;
        this.age = age;
        this.heightInput = heightInput;
        this.weightInput = weightInput;
        this.sex = sex;
    }

    public User(
            String name,
            String surname,
            String email,
            String pass,
            String age,
            String heightInput,
            String weightInput,
            String sex
    ) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.pass = pass;
        this.age = age;
        this.heightInput = heightInput;
        this.weightInput = weightInput;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getHeightInput() {
        return heightInput;
    }

    public void setHeightInput(String heightInput) {
        this.heightInput = heightInput;
    }

    public String getWeightInput() {
        return weightInput;
    }

    public void setWeightInput(String weightInput) {
        this.weightInput = weightInput;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
