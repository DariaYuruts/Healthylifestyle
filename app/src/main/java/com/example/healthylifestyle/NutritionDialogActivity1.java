package com.example.healthylifestyle;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class NutritionDialogActivity1 extends AppCompatActivity {

    Dialog dialogNutrition;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_dialog1);
        TextView btnClose = findViewById(R.id.btnclose);
        btnClose.setOnClickListener(v -> {
            startActivity(new Intent(this, NutritionActivity.class));
            finish();
        });
    }
}