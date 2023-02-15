package com.example.healthylifestyle.settings;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.healthylifestyle.Information.User;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class SettingsViewModel extends ViewModel {

    private final FirebaseAuth auth = FirebaseAuth.getInstance();
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final DatabaseReference users = database.getReference("Users");

    public SettingsViewModel() {}

    private MutableLiveData<User> user;

    public LiveData<User> getCurrentUser() {
        if (user == null) {
            user = new MutableLiveData<>();
            loadUser();
        }
        return user;
    }

    private void loadUser() {
        String currentUserId = Objects.requireNonNull(auth.getCurrentUser()).getUid();
        users.child(currentUserId).get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    user.postValue(task.getResult().getValue(User.class));
                } else {
                    Log.e("Error while getting user", Objects.requireNonNull(task.getException()).toString());
                }
            }
        });
    }
}
