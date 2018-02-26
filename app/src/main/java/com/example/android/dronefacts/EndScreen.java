package com.example.android.dronefacts;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        String s = getIntent().getStringExtra("FINAL_SCORE");

        TextView finalScore = findViewById(R.id.text_view_score);
        finalScore.setText(s);
    }
}
