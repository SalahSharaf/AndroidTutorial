package com.example.android.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class MainActivity extends AppCompatActivity {
    //here i have made global variables to be used in all the code document
    Animation[] animStart;
    CardView[] cards;
    // number of questions is 9 but like an array i like to make it starts from zero
    int numberOfQuestions = 8;
    int currentQuestion = 0;

    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cards = new CardView[9];
        final int duration = 2000;
        animStart = new Animation[9];
        cards[0] = findViewById(R.id.question1);
        cards[1] = findViewById(R.id.question2);
        cards[2] = findViewById(R.id.question3);
        cards[3] = findViewById(R.id.question4);
        cards[4] = findViewById(R.id.question5);
        cards[5] = findViewById(R.id.question6);
        cards[6] = findViewById(R.id.question7);
        cards[7] = findViewById(R.id.question8);
        cards[8] = findViewById(R.id.question9);
        for (int i = 0; i < 9; i++) {
            animStart[i] = AnimationUtils.loadAnimation(this, R.anim.startinganimation);
            animStart[i].setDuration(duration + 200 * i);
            cards[i].startAnimation(animStart[i]);
        }
    }

    public void StartTest(View view) {
        Intent activity = new Intent(this, Question0.class);
        startActivity(activity);
    }
}
