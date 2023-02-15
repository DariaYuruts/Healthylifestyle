package com.example.healthylifestyle;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.healthylifestyle.water.WbalanceActivity;

public class HomeFragment extends Fragment {

    public HomeFragment() {}

    private String selectedTopic = "";

    private LinearLayout calc;
    private LinearLayout nutr;
    private LinearLayout rec;
    private LinearLayout vodbal;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_lk, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        calc = view.findViewById(R.id.lay1);
        nutr = view.findViewById(R.id.lay2);
        rec = view.findViewById(R.id.lay3);
        vodbal = view.findViewById(R.id.lay4);
        setOnClickListeners();
    }

    private void setCalcClickListener() {
        calc.setOnClickListener(view14 -> {
            selectedTopic = "calc";
            calc.setBackgroundResource(R.drawable.round_back_2);
            nutr.setBackgroundResource(R.drawable.round_back);
            rec.setBackgroundResource(R.drawable.round_back);
            vodbal.setBackgroundResource(R.drawable.round_back);
            startActivity(new Intent(getActivity(), CalcActivity.class));
        });
    }

    void setNutrClickListener() {
        nutr.setOnClickListener(view13 -> {
            selectedTopic = "nutr";
            calc.setBackgroundResource(R.drawable.round_back);
            nutr.setBackgroundResource(R.drawable.round_back_2);
            rec.setBackgroundResource(R.drawable.round_back);
            vodbal.setBackgroundResource(R.drawable.round_back);
            startActivity(new Intent(getActivity(), NutritionAndSportsActivity.class));
        });
    }

    void setRecClickListener() {
        rec.setOnClickListener(view12 -> {
            selectedTopic = "rec";
            calc.setBackgroundResource(R.drawable.round_back);
            nutr.setBackgroundResource(R.drawable.round_back);
            rec.setBackgroundResource(R.drawable.round_back_2);
            vodbal.setBackgroundResource(R.drawable.round_back);
            startActivity(new Intent(getActivity(), RecommendActivity.class));
        });
    }

    void setVodbalClickListener() {
        vodbal.setOnClickListener(view1 -> {
            selectedTopic = "vodbal";
            calc.setBackgroundResource(R.drawable.round_back);
            nutr.setBackgroundResource(R.drawable.round_back);
            rec.setBackgroundResource(R.drawable.round_back);
            vodbal.setBackgroundResource(R.drawable.round_back_2);
            startActivity(new Intent(getActivity(), WbalanceActivity.class));
        });
    }

    private void setOnClickListeners() {
        setCalcClickListener();
        setNutrClickListener();
        setRecClickListener();
        setVodbalClickListener();
    }
}