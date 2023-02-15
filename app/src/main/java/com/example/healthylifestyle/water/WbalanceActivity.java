package com.example.healthylifestyle.water;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProvider;

import com.example.healthylifestyle.Information.Water;
import com.example.healthylifestyle.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class WbalanceActivity extends AppCompatActivity {

    AppCompatTextView neededWater, waterCount;

    AppCompatEditText weightInput;

    AppCompatSpinner activity;

    AppCompatButton count, drinkWater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wbalance);
        weightInput = findViewById(R.id.weight_input);
        neededWater = findViewById(R.id.needed_water);
        waterCount = findViewById(R.id.water_count);
        activity = findViewById(R.id.activity);
        count = findViewById(R.id.count);
        drinkWater = findViewById(R.id.drink_glass);
        final WaterBalanceViewModel viewModel = new ViewModelProvider(this).get(WaterBalanceViewModel.class);
        drinkWater.setOnClickListener(v -> {
            viewModel.addWater();
        });
        viewModel.getWaterUserWater().observe(this, water -> {
            waterCount.setText("Выпито: " + water.getMc() + " из " + water.getMax() + "мл" );
            neededWater.setText(water.getMax() + "мл");
        });
        count.setOnClickListener(v -> {
            int weight = Integer.parseInt(weightInput.getText().toString());
            double result = (double) weight / 1000.0 * 40.0;
            String chosenActivity = activity.getItemAtPosition(activity.getSelectedItemPosition()).toString();
            if (chosenActivity.equals("Легкие физические нагрузки")) {
                result += 0.0;
            } else if (chosenActivity.equals("Средние физические нагрузки")) {
                result += 0.4;
            } else {
                result += 0.7;
            }
            int fin = (int) (result * 1000.0);
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date today = new Date();
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH) + 1;
            int day = calendar.get(Calendar.DAY_OF_MONTH);
            Water newWater = new Water(0, fin, day, month, year);
            viewModel.postWater(newWater);
        });
    }
}