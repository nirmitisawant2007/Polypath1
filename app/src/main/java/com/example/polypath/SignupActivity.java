package com.example.polypath;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import java.util.regex.Pattern;

public class SignupActivity extends AppCompatActivity {
    private EditText etEmail, etPass, etName;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;

    // Password Regex: 1 Uppercase, 1 Lowercase, 1 Number, 1 Special Character, Minimum Length 8
    private static final Pattern PASSWORD_REGEX =
            Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=!_.-]).{8,}$");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        // Initialize Firebase instances
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        // Bind UI components
        etEmail = findViewById(R.id.etSignupEmail);
        etPass = findViewById(R.id.etSignupPassword);
        etName = findViewById(R.id.etSignupName);
        Button btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(v -> {
            String name = etName.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String password = etPass.getText().toString().trim();

            // 1. Name Validation
            if (name.isEmpty()) {
                etName.setError("Enter a valid name");
                etName.requestFocus();
                return;
            }

            // 2. Email Validation (Empty & Proper Format check)
            if (email.isEmpty()) {
                etEmail.setError("Enter a valid email");
                etEmail.requestFocus();
                return;
            }
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.setError("Enter valid email format");
                etEmail.requestFocus();
                return;
            }

            // 3. Strict Password Validation (Uppercase, Lowercase, Number, Special Char, Min 8 chars)
            if (password.isEmpty()) {
                etPass.setError("Password is mandatory");
                etPass.requestFocus();
                return;
            }
            if (!PASSWORD_REGEX.matcher(password).matches()) {
                etPass.setError("Must contain an uppercase, a lowercase, a number, a special character, and minimum 8 characters!");
                etPass.requestFocus();
                return;
            }

            // After passing all validations, proceed with Firebase Authentication
            mAuth.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            // Safe User ID retrieval after successful creation
                            String userId = mAuth.getCurrentUser().getUid();

                            // Save user name inside Realtime Database under "Users" node
                            mDatabase.child("Users").child(userId).child("userName").setValue(name)
                                    .addOnSuccessListener(aVoid -> {
                                        Toast.makeText(this, "Account Created & Data Saved!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(SignupActivity.this, FeatureMenuActivity.class));
                                        finish();
                                    })
                                    .addOnFailureListener(e -> {
                                        Toast.makeText(this, "Database Error: " + e.getMessage(), Toast.LENGTH_SHORT).show();
                                    });
                        } else {
                            // Handle registration failure (e.g., email already in use or network issue)
                            Toast.makeText(this, "Registration Failed: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
        });
    }
}