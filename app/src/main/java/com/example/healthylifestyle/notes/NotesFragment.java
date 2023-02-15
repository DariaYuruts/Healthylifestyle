package com.example.healthylifestyle.notes;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.healthylifestyle.R;

public class NotesFragment extends Fragment {

    public NotesFragment() {}

    private AppCompatTextView bmi, bmiDate, cpfc, cpfcDate, waterBalance, waterBalanceDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notes, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bmi = view.findViewById(R.id.body_mass_index);
        bmiDate = view.findViewById(R.id.bmi_Date);
        cpfc = view.findViewById(R.id.cpfc);
        cpfcDate = view.findViewById(R.id.cpfc_date);
        waterBalance = view.findViewById(R.id.water_balance);
        waterBalanceDate = view.findViewById(R.id.water_balance_date);
        final NotesViewModel viewModel = new ViewModelProvider(this).get(NotesViewModel.class);
        viewModel.getCurrentUserBMI().observe(getViewLifecycleOwner(), _bmi -> {
            if (_bmi != null) {
                bmi.setText("ИМТ: " + _bmi.getBmi());
                bmiDate.setText("Дата измерений: " + _bmi.getBmiDate());
            } else {
                bmi.setText("ИМТ: Еще нет данных");
                bmiDate.setText("Дата измерений: Еще нет данных");
            }
        });

        viewModel.getCurrentUserCPFC().observe(getViewLifecycleOwner(), _cpfc -> {
            if (_cpfc != null) {
                cpfc.setText("КБЖУ: " + _cpfc.getCpfc());
                cpfcDate.setText("Дата измерений: " + _cpfc.getCpfcDate());
            } else {
                cpfc.setText("КБЖУ: Еще нет данных");
                cpfcDate.setText("Дата измерений: Еще нет данных");
            }
        });

        viewModel.getCurrentUserWater().observe(getViewLifecycleOwner(), _water -> {
            if (_water != null) {
                waterBalance.setText("Выпито воды: " + _water.getMc() + " из " + _water.getMax() + "мл");
                waterBalanceDate.setText("Дата: " + _water.getDay() + "." + _water.getMonth() + "." + _water.getYear());
            } else {
                waterBalance.setText("Выпито воды: нет данных");
                waterBalanceDate.setText("дата: нет данных");
            }
        });
    }
}