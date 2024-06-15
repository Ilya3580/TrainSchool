package com.example.trainschool;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

public class MainWindowFragment extends Fragment {
    private NavController navController;
    private Button start;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_window, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = findNavController(this);
        start = view.findViewById(R.id.start);

        start.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_main_window_to_fragment_auth);
        });



    }
    public static MainWindowFragment newInstance() {
        return new MainWindowFragment();
    }
}
