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
import com.example.trainschool.rv.ContinuingAdapter;
import com.example.trainschool.rv.ContinuingItem;

import java.util.ArrayList;

public class ContinuingFragment extends Fragment {


    private NavController navController;

    private RecyclerView recyclerView;
    private ImageView back;

   ContinuingAdapter continuingAdapter = new ContinuingAdapter();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_continuing, container, false);
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


        recyclerView.setAdapter(continuingAdapter);

        ArrayList<ContinuingItem> items = new ArrayList<>();


        items.add(new ContinuingItem(R.drawable.cont1, "1min"));
        items.add(new ContinuingItem(R.drawable.cont2, "10x"));
        items.add(new ContinuingItem(R.drawable.cont3, "10x"));
        items.add(new ContinuingItem(R.drawable.cont4, "1min"));
        items.add(new ContinuingItem(R.drawable.cont5, "12x"));
        items.add(new ContinuingItem(R.drawable.cont6, "12x"));
        items.add(new ContinuingItem(R.drawable.cont7, "10x"));


        continuingAdapter.setItems(items);


    }

    public static ContinuingFragment newInstance() {
        return new ContinuingFragment();
    }
}
