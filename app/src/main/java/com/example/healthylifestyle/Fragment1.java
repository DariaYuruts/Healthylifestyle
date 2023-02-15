package com.example.healthylifestyle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.healthylifestyle.Information.BMI;
import com.example.healthylifestyle.data_layer.IndexRepository;

import java.util.Calendar;


public class Fragment1 extends Fragment {
    String result;
    IndexRepository repository;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_1, null);
        repository = new IndexRepository();
        EditText editTextWeight = (EditText) v.findViewById(R.id.weight);
        EditText editTextHeight = (EditText) v.findViewById(R.id.height);
        TextView textView = (TextView) v.findViewById(R.id.result);
        Button button = (Button) v.findViewById(R.id.btncalc);

        button.setOnClickListener(v1 -> {
            float height = Float.parseFloat(String.valueOf(editTextHeight.getText())) / 100;
            float weight = Float.parseFloat(String.valueOf(editTextWeight.getText()));
            float bmi = weight / (height * height);

            if (bmi < 18.5){
                result = "Недостаток веса";
            }
             else if(bmi >= 18.5 && bmi <= 24.9){
                result ="Нормальный вес";
            } else if (bmi >= 25 && bmi <= 29.9){
                result = "Избыточный вес";
            } else {
                result = "Ожирение";
            }
            textView.setText("Результат:\n\n" + bmi + "\n" + result);
             repository.postCurrentUserBMI(new BMI((int) bmi, Calendar.getInstance().getTime().toString()));
        });
        return v;
    }

}