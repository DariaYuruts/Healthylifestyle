package com.example.healthylifestyle;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class SportsActivity extends AppCompatActivity {

    private AppCompatButton part1, part2, part3, part4, part5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports);
        part1 = findViewById(R.id.sport_part1);
        part2 = findViewById(R.id.sport_part2);
        part3 = findViewById(R.id.sport_part3);
        part4 = findViewById(R.id.sport_part4);
        part5 = findViewById(R.id.sport_part5);
        part1.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProgramActivity.class);
            intent.putExtra("title", part1.getText().toString());
            startActivity(intent);
        });
        part2.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProgramActivity.class);
            intent.putExtra("title", part2.getText().toString());
            startActivity(intent);
        });
        part3.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProgramActivity.class);
            intent.putExtra("title", part3.getText().toString());
            startActivity(intent);
        });
        part4.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProgramActivity.class);
            intent.putExtra("title", part4.getText().toString());
            startActivity(intent);
        });
        part5.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProgramActivity.class);
            intent.putExtra("title", part5.getText().toString());
            startActivity(intent);
        });
    }
}