package com.nawslcabs.configuration;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.nawslcabs.app.Welcome;
import com.nawslcabs.database.AppDatabase;
import com.nawslcabs.database.RWServices;
import com.nawslcabs.passengers.PassengerHome;

public class StartApp extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        FirebaseUser firebaseUser = mAuth.getCurrentUser();

        if (firebaseUser != null) {
            // Initialize Read Write Application Database Services
            AppDatabase appDatabase = AppDatabase.getDatabase(this);
            RWServices rwServices = new RWServices(appDatabase);
            rwServices.getUserDetails();

            // Go To Home
            Intent intent = new Intent(StartApp.this, PassengerHome.class);
            startActivity(intent);
            finish();
        } else{
            // Go To Sign In
            Intent intent = new Intent(StartApp.this, Welcome.class);
            startActivity(intent);
            finish();
        }
    }
}