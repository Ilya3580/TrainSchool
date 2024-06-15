package com.example.trainschool.rv;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainschool.R;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class BeginnerAdapter extends RecyclerView.Adapter<BeginnerAdapter.BeginnerViewHolder> {

    private ArrayList<BeginnerItem> items = new ArrayList<>();

    @NonNull
    @Override
    public BeginnerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.beginner_cell, parent, false);
        return new BeginnerViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull BeginnerViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<BeginnerItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    class BeginnerViewHolder extends RecyclerView.ViewHolder {
        private GifImageView gifImageView;
        private TextView text;

        public BeginnerViewHolder(@NonNull View itemView) {
            super(itemView);
            gifImageView = itemView.findViewById(R.id.cell_gif_image_view);
            text = itemView.findViewById(R.id.cell_text_view);
        }

        public void bind(BeginnerItem beginnerItem) {
            gifImageView.setImageResource(beginnerItem.getImageId());
            text.setText(beginnerItem.getText());

        }
    }
}
