package com.example.android.dronefacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        int s = getIntent().getIntExtra("FINAL_SCORE", 0);

        TextView finalScore = findViewById(R.id.text_view_score);
        finalScore.setText(String.valueOf(s));
    }
}
