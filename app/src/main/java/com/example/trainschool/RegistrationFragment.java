package com.example.trainschool;

import static androidx.navigation.fragment.FragmentKt.findNavController;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;

import com.google.firebase.auth.FirebaseAuth;

public class RegistrationFragment extends Fragment {

    private NavController navController;
    private ImageView backRegistration;
    private Button registration;
    private EditText emailEditText;
    private EditText firstPasswordEditText;
    private EditText secondPasswordEditText;
    private FirebaseAuth mAuth;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_registration, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = findNavController(this);
        backRegistration = view.findViewById(R.id.back_registration);
        registration = view.findViewById(R.id.registration);
        emailEditText = view.findViewById(R.id.email);
        firstPasswordEditText = view.findViewById(R.id.first_password);
        secondPasswordEditText = view.findViewById(R.id.second_password);

        mAuth = FirebaseAuth.getInstance();

        registration.setOnClickListener(v -> {
            registration();
        });
        backRegistration.setOnClickListener(v -> {
            navController.popBackStack();
        });
    }
    private void registration(){
        String email = emailEditText.getText().toString();
        String firstPassword = firstPasswordEditText.getText().toString();
        String secondPassword = secondPasswordEditText.getText().toString();
        if(!firstPassword.equals(secondPassword)){
            Toast.makeText(requireContext(),"Неверный пароль", Toast.LENGTH_LONG).show();
            return;
        }

        mAuth.createUserWithEmailAndPassword(email, firstPassword)
                .addOnCompleteListener(requireActivity(), task -> {
                    if (task.isSuccessful()) {
                        mAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(requireActivity(), task1 -> {
                            if (task1.isSuccessful()) {
                                Toast.makeText(requireContext(),"Вам ушло письмо на почту", Toast.LENGTH_LONG).show();
                                navController.popBackStack();
                            }
                        });
                    } else {
                        Toast.makeText(requireContext(),"Произошла ошибка", Toast.LENGTH_LONG).show();

                    }
                });

    }

    public static RegistrationFragment newInstance() {
        return new RegistrationFragment();
    }
}
