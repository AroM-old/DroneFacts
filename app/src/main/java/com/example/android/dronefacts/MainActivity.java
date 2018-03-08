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
    /**
     * Open the quiz layout questions
     **/
    public void start_quiz(View view) {

//        Intent intent = new Intent(MainActivity.this, QuestionsSet1.class);
        Intent intent = new Intent(MainActivity.this, QuestionSet2.class);
        startActivity(intent);
        finish();

    }
}
