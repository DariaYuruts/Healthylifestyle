package com.example.healthylifestyle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class NutritionAndSportsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_and_sports);
        LinearLayout lay1 = findViewById(R.id.lay1);
        LinearLayout lay2 = findViewById(R.id.lay2);
        lay1.setOnClickListener(v -> {
            startActivity(new Intent(this, SportsActivity.class));
        });
        lay2.setOnClickListener(v -> {
            startActivity(new Intent(this, NutritionActivity.class));
        });
    }
}