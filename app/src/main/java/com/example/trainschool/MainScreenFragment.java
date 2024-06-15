package com.example.trainschool;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

public class MainScreenFragment extends Fragment {


    private NavController navController;
    private  ImageView butStart;

    private  ImageView butMedium;
    private  ImageView butPremium;
    private  ImageView schedule;

    private  ImageView trener;
    private  ImageView profile;
    private ImageView back;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main_screen, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = findNavController(this);
        butStart = view.findViewById(R.id.butStart);
        butMedium = view.findViewById(R.id.butMedium);
        butPremium = view.findViewById(R.id.butPremium);

        schedule = view.findViewById(R.id.schedule);
        trener = view.findViewById(R.id.trener);
        profile = view.findViewById(R.id.profile);

        back = view.findViewById(R.id.back);

        back.setOnClickListener(v -> {
            navController.popBackStack();
        });

        butStart.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_main_screen_to_fragment_start);
        });
        butMedium.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_main_screen_to_fragment_medium);
        });
        butPremium.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_main_screen_to_fragment_premium);
        });

        trener.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_main_screen_to_fragment_trener_description);
        });
        schedule.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_main_screen_to_fragment_schedule_basic);
        });
        profile.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_main_screen_to_fragment_profile);
        });

    }

    public static MainScreenFragment newInstance() {
        return new MainScreenFragment();
    }
}
