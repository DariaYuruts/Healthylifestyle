package com.example.healthylifestyle.data_layer;

import android.util.Log;

import com.example.healthylifestyle.Information.MenuDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference menus = database.getReference("Menu");

    public MenuRepository() {}

    public void getDatabaseMenu(MenuCallback callback, String type) {
        menus.child(type).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                List<MenuDatabase> menuArray = new ArrayList<>();
                Iterable<DataSnapshot> snapshots = task.getResult().getChildren();
                for (DataSnapshot snapshot: snapshots) {
                    if (snapshot != null) {
                        MenuDatabase menuDatabase = snapshot.getValue(MenuDatabase.class);
                        menuArray.add(menuDatabase);
                    }
                }
                callback.processData(menuArray.toArray(new MenuDatabase[0]));
            } else {
                Log.e("ERROR", "Error while getting menu");
            }
        });
    }
}
