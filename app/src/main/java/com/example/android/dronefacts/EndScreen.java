package com.example.android.dronefacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_screen);

        int finalScoreCount = getIntent().getIntExtra("FINAL_SCORE", 0);

        TextView finalScore = findViewById(R.id.text_view_score);
        finalScore.setText(String.valueOf(finalScoreCount));

        Button playAgain = findViewById(R.id.play_again);
        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), activity_questions.class);
                startActivity(i);
            }
        });

        Button exitQuiz = findViewById(R.id.exit_quiz);
        exitQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
