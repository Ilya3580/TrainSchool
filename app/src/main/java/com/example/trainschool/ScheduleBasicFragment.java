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


public class ScheduleBasicFragment extends Fragment {
    private NavController navController;
    private ImageView schedule;

    private  ImageView trener;
    private  ImageView profile;
    private  ImageView home;
    private ImageView beginner;
    private ImageView continuing;
    private ImageView profi;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_schedule_basic, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = findNavController(this);
        schedule = view.findViewById(R.id.schedule);
        trener = view.findViewById(R.id.trener);
        profile = view.findViewById(R.id.profile);
        beginner = view.findViewById(R.id.beginner);
        continuing = view.findViewById(R.id.continuing);
        profi = view.findViewById(R.id.profi);
        home = view.findViewById(R.id.home);



        trener.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_schedule_basic_to_fragment_trener_description);
        });
        home.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_schedule_basic_to_fragment_main_screen);
        });
        profile.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_schedule_basic_to_fragment_profile);
        });
        beginner.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_schedule_basic_to_fragment_beginner);
        });
        continuing.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_schedule_basic_to_fragment_continuing);
        });
        profi.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_schedule_basic_to_fragment_profi);
        });


    }
    public static  ScheduleBasicFragment newInstance() {
        return new  ScheduleBasicFragment();
    }
}