package com.example.healthylifestyle.data_layer;


import com.example.healthylifestyle.Information.ExerciseDatabase;

public interface ExerciseCallback {
    void processData(ExerciseDatabase[] exercises);
    void throwException(String message);
}
