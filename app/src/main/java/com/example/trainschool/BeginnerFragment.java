package com.example.trainschool;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.graphics.drawable.Drawable;
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

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class BeginnerFragment extends Fragment {


    private NavController navController;

    private RecyclerView recyclerView;
    private ImageView back;

    BeginnerAdapter beginnerAdapter = new BeginnerAdapter();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_beginner, container, false);
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



        recyclerView.setAdapter(beginnerAdapter);

        ArrayList<BeginnerItem> items = new ArrayList<>();



        items.add(new BeginnerItem(R.drawable.beg1, "1min"));
        items.add(new BeginnerItem(R.drawable.beg2, "10x"));
        items.add(new BeginnerItem(R.drawable.beg3, "10x"));
        items.add(new BeginnerItem(R.drawable.beg4, "12x"));
        items.add(new BeginnerItem(R.drawable.beg5, "1min"));
        items.add(new BeginnerItem(R.drawable.beg6, "1min"));
        items.add(new BeginnerItem(R.drawable.beg7, "12x"));
        items.add(new BeginnerItem(R.drawable.beg8, "10x"));


        beginnerAdapter.setItems(items);


    }

    public static BeginnerFragment newInstance() {
        return new BeginnerFragment();
    }
}
