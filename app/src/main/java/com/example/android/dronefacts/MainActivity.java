package com.example.android.dronefacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
    }

    public void onSplashPageClick(View view) {
        Intent intent = new Intent(this, activity_questions.class);
        startActivity(intent);
    }
}
