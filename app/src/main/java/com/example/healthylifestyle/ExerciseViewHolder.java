package com.example.healthylifestyle;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class ExerciseViewHolder extends RecyclerView.ViewHolder {
    private AppCompatImageView image;
    private AppCompatTextView text, name, number;

    public ExerciseViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.exercise_image);
        text = itemView.findViewById(R.id.exercise_info);
        name = itemView.findViewById(R.id.exercise_name);
        number = itemView.findViewById(R.id.exercise_number);
    }


    public AppCompatImageView getImage() {
        return image;
    }

    public void setImage(AppCompatImageView image) {
        this.image = image;
    }

    public AppCompatTextView getText() {
        return text;
    }

    public void setText(AppCompatTextView text) {
        this.text = text;
    }

    public AppCompatTextView getName() {
        return name;
    }

    public void setName(AppCompatTextView name) {
        this.name = name;
    }

    public AppCompatTextView getNumber() {
        return number;
    }

    public void setNumber(AppCompatTextView number) {
        this.number = number;
    }
}
