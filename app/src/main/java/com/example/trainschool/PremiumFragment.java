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


public class PremiumFragment extends Fragment {
    private NavController navController;
    private ImageView schedule;

    private  ImageView trener;
    private  ImageView profile;
    private  ImageView home;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_premium, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = findNavController(this);
        home = view.findViewById(R.id.home);
        schedule = view.findViewById(R.id.schedule);
        trener = view.findViewById(R.id.trener);
        profile = view.findViewById(R.id.profile);

        home.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_premium_to_fragment_main_screen);
        });
        trener.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_premium_to_fragment_trener_description);
        });
        schedule.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_premium_to_fragment_schedule_basic);
        });
        profile.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_premium_to_fragment_profile);
        });


    }
    public static  PremiumFragment newInstance() {
        return new  PremiumFragment();
    }
}
