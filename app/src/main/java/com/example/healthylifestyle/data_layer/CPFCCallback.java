package com.example.healthylifestyle.data_layer;

import com.example.healthylifestyle.Information.CPFC;

public interface CPFCCallback {
    void processData(CPFC cpfc);
    void throwException(String message);
}
