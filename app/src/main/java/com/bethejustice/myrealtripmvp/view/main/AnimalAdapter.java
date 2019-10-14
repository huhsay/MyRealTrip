package com.bethejustice.myrealtripmvp.view.main;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bethejustice.myrealtripmvp.R;
import com.bethejustice.myrealtripmvp.data.room.Animal;

import java.util.ArrayList;
import java.util.List;

public class AnimalAdapter extends RecyclerView.Adapter<AnimalAdapter.ViewHolder> {

    private List<Animal> items = new ArrayList<>();
    private ItemClickListener itemClickListener;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_name.setText(items.get(position).animal_name);
        holder.tv_type.setText(items.get(position).animal_type.getTypeString());
        holder.itemView.setOnClickListener(view -> itemClickListener.onItemClickListener(items.get(position).animal_type));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    void addItem(List<Animal> animals){
        items = animals;
        notifyDataSetChanged();
    }

    void setOnClickListener(ItemClickListener itemClickListener){
        this.itemClickListener = itemClickListener;
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView tv_type;
        TextView tv_name;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tv_type = itemView.findViewById(R.id.tv_type);
            this.tv_name = itemView.findViewById(R.id.tv_name);
        }
    }
}
