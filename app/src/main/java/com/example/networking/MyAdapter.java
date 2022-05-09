package com.example.networking;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<ViewHolder> {
    private List<Mountain> Mountain;
    public MyAdapter(ArrayList<Mountain> mountainArray) {
        this.Mountain = Mountain;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_second, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.name.setText(Mountain.get(position).getName());
        holder.location.setText(Mountain.get(position).getLocation());
        holder.size.setText(String.valueOf(Mountain.get(position).getSize()));
    }

    @Override
    public int getItemCount() {
        return Mountain.size();
    }
}
