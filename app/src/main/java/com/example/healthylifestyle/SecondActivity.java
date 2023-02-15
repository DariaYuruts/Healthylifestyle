package com.example.healthylifestyle;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.healthylifestyle.notes.NotesFragment;
import com.example.healthylifestyle.settings.SettingsFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class SecondActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        getSupportFragmentManager().beginTransaction().add(R.id.container, new HomeFragment()).commit();
        bottomNavigationView = findViewById(R.id.bottombar);
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                transaction.addToBackStack(null).setReorderingAllowed(true);
                switch(item.getItemId()) {
                    case R.id.lk:
                        transaction.replace(R.id.container, new HomeFragment()).commit();
                        return true;
                    case R.id.notes:
                        transaction.replace(R.id.container, new NotesFragment()).commit();
                        return true;
                    case R.id.settings:
                        transaction.replace(R.id.container, new SettingsFragment()).commit();
                        return true;
                }
                return false;
            }
        });
    }
}
