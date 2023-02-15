package com.example.healthylifestyle.data_layer;

import com.example.healthylifestyle.Information.Water;

public interface WaterBalanceCallback {
    void processData(Water water);
    void throwException(String message);
}
