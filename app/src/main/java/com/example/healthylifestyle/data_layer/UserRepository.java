package com.example.healthylifestyle.data_layer;

import com.example.healthylifestyle.Information.User;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class UserRepository {
    private final FirebaseAuth auth = FirebaseAuth.getInstance();
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference users = database.getReference("Users");

    public UserRepository() {}

    private String getCurrentUserId() {
        return Objects.requireNonNull(auth.getCurrentUser()).getUid();
    }

    public void getCurrentUser(UserCallBack callBack) {
        String currentUserId = getCurrentUserId();
        users.child(currentUserId).get().addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                User user = task.getResult().getValue(User.class);
                callBack.processData(user);
            } else {
                callBack.throwException("Error while getting current user info");
            }
        });
    }
}
