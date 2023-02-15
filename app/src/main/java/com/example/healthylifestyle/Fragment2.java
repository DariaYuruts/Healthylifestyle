package com.example.healthylifestyle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.healthylifestyle.Information.CPFC;
import com.example.healthylifestyle.data_layer.IndexRepository;

import java.util.Calendar;


public class Fragment2 extends Fragment {

    EditText editTextAge, editTextWeight, editTextHeight;
    TextView resultTextView;
    Spinner spinnerActivity, spinner1;
    Button calculate;
    IndexRepository repository;

    public Fragment2() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_2, container, false);
        editTextAge = v.findViewById(R.id.age);
        editTextWeight = v.findViewById(R.id.weight);
        editTextHeight = v.findViewById(R.id.height);
        resultTextView = v.findViewById(R.id.result);
        spinnerActivity = v.findViewById(R.id.activity);
        spinner1 = v.findViewById(R.id.spinner1);
        calculate = v.findViewById(R.id.btncalc);
        repository = new IndexRepository();
        return v;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final ViewModel2 viewModel= new ViewModelProvider(this).get(ViewModel2.class);
        viewModel.getCurrentUser().observe(getViewLifecycleOwner(), user -> {
            editTextAge.setText(user.getAge());
            editTextWeight.setText(user.getWeightInput());
            editTextHeight.setText(user.getHeightInput());
        });
        calculate.setOnClickListener(v -> {
            String sex = spinner1.getItemAtPosition(spinner1.getSelectedItemPosition()).toString();
            String activityType = spinnerActivity.getItemAtPosition(spinnerActivity.getSelectedItemPosition()).toString();
            String age = editTextAge.getText().toString();
            String weight = editTextWeight.getText().toString();
            String height = editTextHeight.getText().toString();
            int result = (int) (10.0 * Double.parseDouble(weight) + 6.25 * Double.parseDouble(height) - 5.0 * Double.parseDouble(age));
            if (sex.equals("Мужской")) {
                result += 5;
            } else {
                result -= 161;
            }
            switch (activityType) {
                case "Малоподвижный":
                    result *= 1.2;
                    break;
                case "Тренировки 1–3 раза в неделю":
                    result *= 1.375;
                    break;
                case "Тренировки 3–5 раза в неделю":
                    result *= 1.55;
                    break;
                case "Высокие нагрузки каждый день":
                    result *= 1.7;
                    break;
                case "Экстремальные нагрузки":
                    result *= 1.9;
                    break;

            }
            resultTextView.setText("Результат: " + String.valueOf(result));
            repository.postCurrentUserCPFC(new CPFC(result, Calendar.getInstance().getTime().toString()));
        });
    }
}



