package com.example.healthylifestyle.water;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.healthylifestyle.Information.Water;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Calendar;
import java.util.Objects;

public class WaterBalanceViewModel extends ViewModel {
    private final FirebaseAuth auth = FirebaseAuth.getInstance();
    private final FirebaseDatabase database = FirebaseDatabase.getInstance();
    private final String currentUserId = Objects.requireNonNull(auth.getCurrentUser()).getUid();
    private final DatabaseReference waters = database.getReference("Water").child(currentUserId);

    public WaterBalanceViewModel() {}

    private MutableLiveData<Water> water;

    public LiveData<Water> getWaterUserWater() {
        if (water == null) {
            water = new MutableLiveData<>();
            loadWater();
        }
        return water;
    }

    private void loadWater() {
        waters.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                Water data = snapshot.getValue(Water.class);
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH) + 1;
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                if (data == null || (year != data.getYear() || month != data.getMonth() || day != data.getDay())) {
                    Water newWater = new Water(0, 0, day, month, year);
                    if (data != null) newWater.setMax(data.getMax());
                    postWater(newWater);
                    water.postValue(newWater);
                } else {
                    water.postValue(data);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Log.e("Error while getting current users amount of water", Objects.requireNonNull(error.toString()));
            }
        });
    }

    public void addWater() {
        waters.get().addOnCompleteListener(new OnCompleteListener<DataSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DataSnapshot> task) {
                if (task.isSuccessful()) {
                    Water oldWater = task.getResult().getValue(Water.class);
                    if (oldWater != null) {
                        Water newWater = new Water(oldWater.getMc() + 300, oldWater.getMax(), oldWater.getDay(), oldWater.getMonth(), oldWater.getYear());
                        postWater(newWater);
                    }
                }
            }
        });
    }

    public void postWater(Water water) {
        waters.setValue(water);
    }
}
