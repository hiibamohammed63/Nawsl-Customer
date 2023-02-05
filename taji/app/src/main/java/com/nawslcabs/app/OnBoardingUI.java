package com.nawslcabs.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nawslcabs.R;
import com.nawslcabs.database.AppDatabase;
import com.nawslcabs.database.RWServices;
import com.nawslcabs.global.Variables;
import com.nawslcabs.home.Home;

public class OnBoardingUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_on_boarding_ui);

        Variables.ACTIVITY_STATE = 0;
        AppDatabase appDatabase = AppDatabase.getDatabase(this);
        RWServices rwServices = new RWServices(appDatabase);
        String firstName = rwServices.getFirstName();

        TextView helloText = findViewById(R.id.helloText);
        String hello = "Hello " + firstName + ",";
        helloText.setText(hello);

        final Button finishSetup = findViewById(R.id.finishSetup);
        finishSetup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Variables.ACTIVITY_STATE == 0) {
                    Variables.ACTIVITY_STATE = 1;

                    Intent intent = new Intent(OnBoardingUI.this, Home.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }


}
