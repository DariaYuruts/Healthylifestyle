package com.example.healthylifestyle;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NutritionDialogActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_dialog2);
        TextView btnClose = findViewById(R.id.btnclose);
        btnClose.setOnClickListener(v -> {
            startActivity(new Intent(this, NutritionActivity.class));
            finish();
        });
    }
}