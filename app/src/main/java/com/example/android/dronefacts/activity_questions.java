package com.example.android.dronefacts;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class activity_questions extends AppCompatActivity {

    /**
     * Variables to check user state and change questions
     **/
    private boolean done;
    private int questionNo;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);
        //Set text view to first question from the string array list
        String[] questions = getResources().getStringArray(R.array.questions);
        TextView t = findViewById(R.id.question);
        t.setText(questions[questionNo]);

        //Hide the text view, Image and next button when app start
        findViewById(R.id.answer_image).setVisibility(View.INVISIBLE);
        findViewById(R.id.correctOrNot).setVisibility(View.INVISIBLE);
        findViewById(R.id.next_button).setVisibility(View.INVISIBLE);
    }

    /**
     * Show a question hint for the user
     * */
    public void onHintClick(View view) {

        String[] hints = getResources().getStringArray(R.array.hints);

        Toast tosty = Toast.makeText(getApplicationContext(),hints[questionNo], Toast.LENGTH_SHORT);
        tosty.show();
    }

    /**
     * Check user question and display a message showing the right answer,
     * if answer is wrong show the answer and the next button to populate
     * screen with the next question when user click the ok button
     * */
    public void onAnswerClick(View view) {


        if (done == false){
            String answer = ((EditText)findViewById(R.id.answer)).getText().toString();
            String[] answers = getResources().getStringArray(R.array.answers);
            String correctAnswer = answers[questionNo];
            answer = answer.toUpperCase();
            correctAnswer = correctAnswer.toUpperCase();

            if (answer.equals(correctAnswer)) {

                TextView t = findViewById(R.id.correctOrNot);
                t.setText("Correct!");
                t.setGravity(Gravity.CENTER);
                ImageView i = findViewById(R.id.answer_image);
                i.setImageResource((R.mipmap.dronerighthdpi));
                score++; //Tracking correct answer.
                answerSumitted();

            }else {

                TextView t = findViewById(R.id.correctOrNot);
                t.setTextSize(30);
                t.setText("Correct answer: " + correctAnswer);
                t.setGravity(Gravity.CENTER);
                ImageView i = findViewById(R.id.answer_image);
                i.setImageResource((R.mipmap.dronewronghdpi));
                answerSumitted();
            }

            done = true;
        }


    }

    /**
     * Show a correct or incorrect message and apply a small animation
     * to show the message.
     * */
    public void answerSumitted(){

            findViewById(R.id.answer_image).setVisibility(View.VISIBLE);
            TranslateAnimation animation = new TranslateAnimation(0,0,2000,0);
            animation.setDuration(1000);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    findViewById(R.id.correctOrNot).setVisibility(View.VISIBLE);
                    findViewById(R.id.next_button).setVisibility(View.VISIBLE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
            findViewById(R.id.answer_image).startAnimation(animation);
        }


        /**
         * Clear the screen and provide the next question to the user
         * when user click the next button.
         * */
    public void onNextClick(View view) {
        if (done){
            String[] questions = getResources().getStringArray(R.array.questions);
            if (questionNo < (questions.length - 1)){
                questionNo = questionNo + 1;
                TextView t = findViewById(R.id.question);
                t.setText(questions[questionNo]);

                //Show actual questions and total of questions to user
                TextView q = findViewById(R.id.score);
                q.setText(String.valueOf(questionNo + 1 + "/" + questions.length));

                //Hide the answer animation when go to next questions
                findViewById(R.id.answer_image).setVisibility(View.INVISIBLE);
                findViewById(R.id.correctOrNot).setVisibility(View.INVISIBLE);
                findViewById(R.id.next_button).setVisibility(View.INVISIBLE);
                EditText et = findViewById(R.id.answer);
                et.setText("");

                done = false;
            }else{
                //Call the end of screen and show the final score to user
                Log.d("End of screen call", "Show end screen");
                Intent i = new Intent(this, EndScreen.class);
                i.putExtra("FINAL_SCORE", score);
                startActivity(i);
                finish();
            }
        }
    }
}
