package com.example.healthylifestyle.data_layer;

import com.example.healthylifestyle.Information.ExerciseDatabase;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;

public class ExerciseRepository {
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference sports = database.getReference("Sport");

    public ExerciseRepository() {}

    public void getDatabaseExercise(ExerciseCallback callback, String part) {
        sports.child(part).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                List<ExerciseDatabase> exerciseArray = new ArrayList<>();
                Iterable<DataSnapshot> snapshots = task.getResult().getChildren();
                for (DataSnapshot snapshot: snapshots) {
                    if (snapshot != null) {
                        ExerciseDatabase exerciseDatabase = snapshot.getValue(ExerciseDatabase.class);
                        exerciseArray.add(exerciseDatabase);
                    }
                }
                callback.processData(exerciseArray.toArray(new ExerciseDatabase[0]));
            } else {
                callback.throwException("Error while getting exercises");
            }
        });
    }
}
