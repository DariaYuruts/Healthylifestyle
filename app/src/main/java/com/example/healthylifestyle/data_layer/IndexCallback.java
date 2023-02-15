package com.example.healthylifestyle.data_layer;

import com.example.healthylifestyle.Information.Indexes;

public interface IndexCallback {
    void processData(Indexes indexes);
    void throwException(String message);
}
