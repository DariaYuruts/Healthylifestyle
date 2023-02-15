package com.example.healthylifestyle.data_layer;

import com.example.healthylifestyle.Information.BMI;

public interface BMICallback {
    void processData(BMI bmi);
    void throwException(String message);
}
