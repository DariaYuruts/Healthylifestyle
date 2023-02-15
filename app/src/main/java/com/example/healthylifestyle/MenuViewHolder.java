package com.example.healthylifestyle;

import android.view.View;

import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

public class MenuViewHolder extends RecyclerView.ViewHolder {
    private AppCompatImageView image;
    private AppCompatTextView breakfast, lunch, afternoonSnack, dinner;

    MenuViewHolder(View view) {
        super(view);
        image = view.findViewById(R.id.image);
        breakfast = view.findViewById(R.id.breakfast);
        lunch = view.findViewById(R.id.lunch);
        afternoonSnack = view.findViewById(R.id.afternoon_snack);
        dinner = view.findViewById(R.id.dinner);
    }

    public AppCompatImageView getImage() {
        return image;
    }

    public void setImage(AppCompatImageView image) {
        this.image = image;
    }

    public AppCompatTextView getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(AppCompatTextView breakfast) {
        this.breakfast = breakfast;
    }

    public AppCompatTextView getLunch() {
        return lunch;
    }

    public void setLunch(AppCompatTextView lunch) {
        this.lunch = lunch;
    }

    public AppCompatTextView getAfternoonSnack() {
        return afternoonSnack;
    }

    public void setAfternoonSnack(AppCompatTextView afternoonSnack) {
        this.afternoonSnack = afternoonSnack;
    }

    public AppCompatTextView getDinner() {
        return dinner;
    }

    public void setDinner(AppCompatTextView dinner) {
        this.dinner = dinner;
    }
}
