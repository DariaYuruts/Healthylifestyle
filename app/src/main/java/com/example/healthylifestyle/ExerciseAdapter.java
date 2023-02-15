package com.example.healthylifestyle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthylifestyle.Information.Exercise;


public class ExerciseAdapter extends RecyclerView.Adapter<ExerciseViewHolder> {

    private Exercise[] array;

    public ExerciseAdapter(Exercise[] array) {
        this.array = array;
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.exercise_item, parent, false);
        return new ExerciseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        if (array[position].getImage() != null) {
            holder.getImage().setVisibility(View.VISIBLE);
            holder.getImage().setImageBitmap(array[position].getImage());
        } else {
            holder.getImage().setVisibility(View.GONE);
        }
        holder.getNumber().setText(array[position].getNumber());
        holder.getText().setText(array[position].getText());
        holder.getName().setText(array[position].getName());
    }

    @Override
    public int getItemCount() {
        return array.length;
    }

    public void setArray(Exercise[] array) {
        this.array = array;
    }
}
