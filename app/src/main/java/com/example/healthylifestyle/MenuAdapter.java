package com.example.healthylifestyle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.healthylifestyle.Information.Menu;

public class MenuAdapter extends RecyclerView.Adapter<MenuViewHolder> {
    private Menu[] array;

    public MenuAdapter() {
        array = new Menu[0];
    };

    public MenuAdapter(Menu[] array) {
        this.array = array;
    }

    @NonNull
    @Override
    public MenuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_menu, parent, false);
        return new MenuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MenuViewHolder holder, int position) {
        holder.getBreakfast().setText(array[position].getBreakfast());
        holder.getLunch().setText(array[position].getLunch());
        holder.getAfternoonSnack().setText(array[position].getAfternoonSnack());
        holder.getDinner().setText(array[position].getDinner());
        holder.getImage().setImageBitmap(array[position].getImage());
    }

    @Override
    public int getItemCount() {
        return array.length;
    }

    public Menu[] getArray() {
        return array;
    }

    public void setArray(Menu[] array) {
        this.array = array;
    }
}
