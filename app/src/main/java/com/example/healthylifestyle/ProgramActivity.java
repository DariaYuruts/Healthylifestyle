package com.example.healthylifestyle;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthylifestyle.Information.Exercise;
import com.google.android.material.appbar.MaterialToolbar;

public class ProgramActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    MaterialToolbar toolbar;

    ExerciseAdapter adapter;

    @SuppressLint("WrongThread")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_program);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String title = extras.getString("title");
            toolbar = findViewById(R.id.toolbar);
            recyclerView = findViewById(R.id.recycler_view);
            toolbar.setTitle(title);
            String dataBaseTitle = "";
            switch (title) {
                case "Этап 1: ходьба на месте":
                    dataBaseTitle = "part_1";
                    break;
                case "Этап 2: суставная гимнастика":
                    dataBaseTitle = "part_2";
                    break;
                case "Этап 3: динамическая растяжка мышц":
                    dataBaseTitle = "part_3";
                    break;
                case "Этап 4: кардио-разогрев":
                    dataBaseTitle = "part_4";
                    break;
                case "Этап 5: восстановление дыхания":
                    dataBaseTitle = "part_5";
                    break;
            }
            final ProgramViewModel viewModel = new ViewModelProvider(this).get(ProgramViewModel.class);
            adapter = new ExerciseAdapter(new Exercise[0]);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
            viewModel.getExercises(dataBaseTitle).observe(this, exercises -> {
                adapter.setArray(exercises);
                adapter.notifyDataSetChanged();
            });
        }
    }
}