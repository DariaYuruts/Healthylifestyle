package com.example.healthylifestyle.data_layer;

import com.example.healthylifestyle.Information.BMI;
import com.example.healthylifestyle.Information.CPFC;
import com.example.healthylifestyle.Information.Indexes;
import com.example.healthylifestyle.Information.Water;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class IndexRepository {

    private final FirebaseAuth auth = FirebaseAuth.getInstance();
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference indexes = database.getReference("Indexes");
    private final String currentUserId = Objects.requireNonNull(auth.getCurrentUser()).getUid();
    private final DatabaseReference waterReference = database.getReference("Water").child(currentUserId);


    public IndexRepository() {}

    private String getCurrentUserId() {
        return Objects.requireNonNull(auth.getCurrentUser()).getUid();
    }

    public void getCurrentUserIndexes(IndexCallback indexCallback) {
        indexes.child(currentUserId).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Indexes indexes = task.getResult().getValue(Indexes.class);
                indexCallback.processData(indexes);
            } else {
                indexCallback.throwException("Error while getting indexes of current user");
            }
        });
    }

    public void getCurrentUserBMI(BMICallback bmiCallback) {
        indexes.child(currentUserId).child("BMI").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                BMI bmi = task.getResult().getValue(BMI.class);
                bmiCallback.processData(bmi);
            } else {
                bmiCallback.throwException("Error while getting current user bmi");
            }
        });
    }

    public void getCurrentUserCPFC(CPFCCallback cpfcCallback) {
        indexes.child(currentUserId).child("CPFC").get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                CPFC cpfc = task.getResult().getValue(CPFC.class);
                cpfcCallback.processData(cpfc);
            } else {
                cpfcCallback.throwException("Error while getting current user cpfc");
            }
        });
    }

    public void getCurrentUserWaterBalance(WaterBalanceCallback callback) {
        waterReference.get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Water water = task.getResult().getValue(Water.class);
                callback.processData(water);
            } else {
                callback.throwException("Error while getting current user water balance");
            }
        });
    }

    public void postCurrentUserBMI(BMI bmi) {
        indexes.child(currentUserId).child("BMI").setValue(bmi);
    }

    public void postCurrentUserCPFC(CPFC cpfc) {
        indexes.child(currentUserId).child("CPFC").setValue(cpfc);
    }
}
