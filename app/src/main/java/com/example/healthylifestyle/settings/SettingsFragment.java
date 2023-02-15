package com.example.healthylifestyle.settings;

import static android.content.Context.MODE_PRIVATE;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.healthylifestyle.MainActivity;
import com.example.healthylifestyle.R;
import com.example.healthylifestyle.utils.PreferenceConstants;
import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textview.MaterialTextView;

public class SettingsFragment extends Fragment {

    public SettingsFragment() {}

    private MaterialTextView nameSurnameTextView;

    private MaterialTextView emailTextView;

    private MaterialTextView ageTextView;

    private MaterialTextView sexTextView;

    private MaterialTextView heightTextView;

    private MaterialTextView weightTextView;

    private MaterialToolbar toolbar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_settings, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nameSurnameTextView = view.findViewById(R.id.name);
        emailTextView = view.findViewById(R.id.email);
        ageTextView = view.findViewById(R.id.age);
        sexTextView = view.findViewById(R.id.sex);
        heightTextView = view.findViewById(R.id.height);
        weightTextView = view.findViewById(R.id.weight);
        toolbar = view.findViewById(R.id.toolbar);

        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                   case R.id.exit :
                       Snackbar.make(view,"Выполнен выход из аккаунта", Snackbar.LENGTH_SHORT).show();
                       SharedPreferences preferences = requireContext().getSharedPreferences(PreferenceConstants.FILE_NAME, MODE_PRIVATE);
                       preferences.edit()
                               .putString(PreferenceConstants.EMAIL, null)
                               .putString(PreferenceConstants.PASSWORD, null)
                               .apply();
                       startActivity(new Intent(getActivity(), MainActivity.class));
                       return true;
                    default:
                        return false;
                }
            }
        });
        final SettingsViewModel viewModel = new ViewModelProvider(this).get(SettingsViewModel.class);
        viewModel.getCurrentUser().observe(getViewLifecycleOwner(), user -> {
            nameSurnameTextView.setText(user.getName() + " " + user.getSurname());
            emailTextView.setText(user.getEmail());
            ageTextView.setText("Возраст: " + user.getAge());
            sexTextView.setText("Пол: " + user.getSex());
            heightTextView.setText("Рост: " + user.getHeightInput() + "см");
            weightTextView.setText("Вес: " +user.getWeightInput() + "кг");
        });
    }
}