package com.example.trainschool;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class ProfileFragment extends Fragment {
    private NavController navController;
    private ImageView schedule;

    private  ImageView trener;
    private  ImageView profile;
    private  ImageView home;

    private TextView emailName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_profile, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = findNavController(this);
        schedule = view.findViewById(R.id.schedule);
        trener = view.findViewById(R.id.trener);
        profile = view.findViewById(R.id.profile);
        home = view.findViewById(R.id.home);
        emailName = view.findViewById(R.id.email_name);
        emailName.setText(FirebaseAuth.getInstance().getCurrentUser().getEmail());

        trener.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_profile_to_fragment_trener_description);
        });
        home.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_profile_to_fragment_main_screen);
        });
        schedule.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_profile_to_fragment_schedule_basic);
        });




    }
    public static  ProfileFragment newInstance() {
        return new  ProfileFragment();
    }
}
