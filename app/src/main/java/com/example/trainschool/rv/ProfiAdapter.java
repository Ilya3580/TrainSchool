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

public class ProfiAdapter extends RecyclerView.Adapter<ProfiAdapter.ProfiViewHolder> {

    private ArrayList<ProfiItem> items = new ArrayList<>();

    @NonNull
    @Override
    public ProfiViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View itemView = inflater.inflate(R.layout.profi_cell, parent, false);
        return new ProfiViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfiViewHolder holder, int position) {
        holder.bind(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public void setItems(ArrayList<ProfiItem> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    class ProfiViewHolder extends RecyclerView.ViewHolder {
        private GifImageView gifImageView;
        private TextView text;

        public ProfiViewHolder(@NonNull View itemView) {
            super(itemView);
            gifImageView = itemView.findViewById(R.id.cell_gif_image_view);
            text = itemView.findViewById(R.id.cell_text_view);
        }

        public void bind(ProfiItem profiItem) {
            gifImageView.setImageResource(profiItem.getImageId());
            text.setText(profiItem.getText());

        }
    }
}
