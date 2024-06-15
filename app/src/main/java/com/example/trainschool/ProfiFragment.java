package com.example.trainschool;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.trainschool.rv.BeginnerAdapter;
import com.example.trainschool.rv.BeginnerItem;
import com.example.trainschool.rv.ProfiAdapter;
import com.example.trainschool.rv.ProfiItem;

import java.util.ArrayList;

public class ProfiFragment extends Fragment {


    private NavController navController;

    private RecyclerView recyclerView;
    private ImageView back;

    ProfiAdapter profiAdapter = new ProfiAdapter();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profi, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = findNavController(this);
        back = view.findViewById(R.id.back);

        back.setOnClickListener(v -> {
            navController.popBackStack();
        });
        recyclerView = view.findViewById(R.id.recycler_view);


        recyclerView.setAdapter(profiAdapter);

        ArrayList<ProfiItem> items = new ArrayList<>();


        items.add(new ProfiItem(R.drawable.prof1, "10x"));
        items.add(new ProfiItem(R.drawable.prof2, "10x"));
        items.add(new ProfiItem(R.drawable.prof3, "12x"));
        items.add(new ProfiItem(R.drawable.prof4, "12x"));
        items.add(new ProfiItem(R.drawable.prof5, "12x"));
        items.add(new ProfiItem(R.drawable.prof6, "14x"));
        items.add(new ProfiItem(R.drawable.prof7, "14x"));
        items.add(new ProfiItem(R.drawable.prof8, "12x"));


        profiAdapter.setItems(items);


    }

    public static ProfiFragment newInstance() {
        return new ProfiFragment();
    }
}
