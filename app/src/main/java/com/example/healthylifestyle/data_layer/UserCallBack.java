package com.example.healthylifestyle.data_layer;

import com.example.healthylifestyle.Information.User;

public interface UserCallBack {
    void processData(User user);
    void throwException(String message);
}
