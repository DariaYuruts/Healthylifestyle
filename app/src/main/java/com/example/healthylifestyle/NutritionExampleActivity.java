package com.example.healthylifestyle;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.appbar.MaterialToolbar;

public class NutritionExampleActivity extends AppCompatActivity {

    MaterialToolbar toolbar;

    MenuAdapter adapter;

    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrition_example);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String type = extras.getString("type");
            toolbar = findViewById(R.id.toolbar);
            recyclerView = findViewById(R.id.recycler_view);
            final MenuViewModel viewModel = new ViewModelProvider(this).get(MenuViewModel.class);
            String databaseType = "";
            adapter = new MenuAdapter();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(adapter);
            switch (type) {
                case "Мужчина":
                    toolbar.setTitle("Пример меню для мужчины");
                    databaseType = "male";
                    break;
                case "Женщина":
                    toolbar.setTitle("Пример меню для женщины");
                    databaseType = "female";
                    break;
                case "Ребёнок":
                    toolbar.setTitle("Пример меню для ребёнка");
                    databaseType = "child";
                    break;
            }
            viewModel.getMenuArray(databaseType).observe(this, menuArray -> {
                adapter.setArray(menuArray);
                adapter.notifyDataSetChanged();
            });
        }
    }
}