package com.example.trainschool;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class AuthFragment extends Fragment {


    private NavController navController;
    private Button entrance;
    private Button registration;
    private EditText emailEditText;
    private EditText passwordEditText;
    private FirebaseAuth mAuth;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_auth, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        navController = findNavController(this);
        if(mAuth.getCurrentUser() != null && mAuth.getCurrentUser().isEmailVerified()) {
            navController.navigate(R.id.action_fragment_auth_to_fragment_main_screen);
        }

        entrance = view.findViewById(R.id.entrance);
        registration = view.findViewById(R.id.registration);
        emailEditText = view.findViewById(R.id.email);
        passwordEditText = view.findViewById(R.id.password);

        entrance.setOnClickListener(v -> {
            auth();
        });
        registration.setOnClickListener(v -> {
            navController.navigate(R.id.action_fragment_auth_to_registration_fragment);
        });


    }

    private void auth() {
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(task -> {
            if(task.isComplete()) {
                FirebaseUser firebaseUser = mAuth.getCurrentUser();
                if(firebaseUser == null) {
                    Toast.makeText(requireContext(),"Произошла ошибка",Toast.LENGTH_LONG).show();
                    return;
                }

                if(firebaseUser.isEmailVerified()) {
                    navController.navigate(R.id.action_fragment_auth_to_fragment_main_screen);
                } else {
                    Toast.makeText(requireContext(),"Подтвердите почту",Toast.LENGTH_LONG).show();
                }
            }

        });

    }

    public static AuthFragment newInstance() {
        return new AuthFragment();
    }
}