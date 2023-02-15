package com.example.healthylifestyle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatSpinner;


public class NutritionActivity extends AppCompatActivity {

    AppCompatButton btn1, btn2, btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition);
        btn1 = findViewById(R.id.nutrition_necessity);
        btn2 = findViewById(R.id.nutrition_menu_guide);
        btn3 = findViewById(R.id.nutrition_menu_example);
        btn1.setOnClickListener(v -> {
            startActivity(new Intent(this, NutritionDialogActivity1.class));
            finish();
        });
        btn2.setOnClickListener(v -> {
            startActivity(new Intent(this, NutritionDialogActivity2.class));
            finish();
        });
        btn3.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(this);
            dialog.setTitle("Выбор типа меню");
            View view = LayoutInflater.from(this).inflate(R.layout.menu_type, null);
            dialog.setView(view);
            dialog.setNegativeButton("Отмена", (dialog1, which) -> {
                dialog1.dismiss();
            });
            dialog.setPositiveButton("Подтвердить", (dialog12, which) -> {
                AppCompatSpinner spinner = view.findViewById(R.id.type);
                String choice = spinner.getItemAtPosition(spinner.getSelectedItemPosition()).toString();
                Intent intent = new Intent(this, NutritionExampleActivity.class);
                intent.putExtra("type", choice);
                startActivity(intent);
            });
            dialog.show();
        });
    }
}