package com.example.trainschool.rv;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainschool.R;

import java.util.ArrayList;

import pl.droidsonroids.gif.GifImageView;

public class ContinuingAdapter extends RecyclerView.Adapter<ContinuingAdapter.ContinuingViewHolder> {

    private ArrayList<ContinuingItem> items = new ArrayList<>();

    @NonNull
    @Override
    public ContinuingViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.continuing_cell, parent, false);
        return new ContinuingViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ContinuingViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<ContinuingItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    class ContinuingViewHolder extends RecyclerView.ViewHolder {
        private GifImageView gifImageView;
        private TextView text;

        public ContinuingViewHolder(@NonNull View itemView) {
            super(itemView);
            gifImageView = itemView.findViewById(R.id.cell_gif_image_view);
            text = itemView.findViewById(R.id.cell_text_view);
        }

        public void bind(ContinuingItem continuingItem) {
            gifImageView.setImageResource(continuingItem.getImageId());
            text.setText(continuingItem.getText());

        }
    }
}