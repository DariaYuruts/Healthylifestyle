package com.example.healthylifestyle.data_layer;

import com.example.healthylifestyle.Information.MenuDatabase;

public interface MenuCallback {
    void processData(MenuDatabase[] menuDatabases);
    void throwException(String message);
}
