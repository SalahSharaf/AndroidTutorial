package com.example.android.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //here i have made global variables to be used in all the code document

    // number of questions is 9 but like an array i like to make it starts from zero
    public static int currentQuestion = 0;
    public static boolean continueTest, showResult;
    public static boolean[] btnEnabled = new boolean[7];
    public static boolean[] RightAnswer = new boolean[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        animationsTask();
        Button[] btnsEnabled = new Button[7];
        btnsEnabled[0] = findViewById(R.id.question2Button);
        btnsEnabled[1] = findViewById(R.id.question3Button);
        btnsEnabled[2] = findViewById(R.id.question4Button);
        btnsEnabled[3] = findViewById(R.id.question5Button);
        btnsEnabled[4] = findViewById(R.id.question6Button);
        btnsEnabled[5] = findViewById(R.id.question7Button);
        btnsEnabled[6] = findViewById(R.id.question8Button);
        for (int i = 0; i < btnsEnabled.length; i++) {
            btnsEnabled[i].setEnabled(btnEnabled[i]);
        }
        TextView text = findViewById(R.id.AnswersMessage);
        String message = getString(R.string._0_of_8_questions_have_been_answered, currentQuestion + " ");
        text.setText(message);
        Button btnContiue = findViewById(R.id.continueTest);
        Button btnShowReslut = findViewById(R.id.resultButton);
        btnContiue.setEnabled(continueTest);
        btnShowReslut.setEnabled(showResult);
    }

    void animationsTask() {
        CardView[] cards = new CardView[8];
        final int duration = 1500;
        Animation[] animStart = new Animation[8];
        cards[0] = findViewById(R.id.question1);
        cards[1] = findViewById(R.id.question2);
        cards[2] = findViewById(R.id.question3);
        cards[3] = findViewById(R.id.question4);
        cards[4] = findViewById(R.id.question5);
        cards[5] = findViewById(R.id.question6);
        cards[6] = findViewById(R.id.question7);
        cards[7] = findViewById(R.id.question8);
        for (int i = 0; i < cards.length; i++) {
            animStart[i] = AnimationUtils.loadAnimation(this, R.anim.startinganimation);
            animStart[i].setDuration(duration + 200 * i);
            cards[i].startAnimation(animStart[i]);
        }
    }

    public void Continue(View view) {
        for (int i = 0; i < btnEnabled.length; i++) {
            if (btnEnabled[i] && i == 0) {
                StartQuestion2(view);
            } else if (btnEnabled[i] && i == 1) {
                StartQuestion3(view);
            } else if (btnEnabled[i] && i == 2) {
                StartQuestion4(view);
            } else if (btnEnabled[i] && i == 3) {
                StartQuestion5(view);
            } else if (btnEnabled[i] && i == 4) {
                StartQuestion6(view);
            } else if (btnEnabled[i] && i == 5) {
                StartQuestion7(view);
            } else if (btnEnabled[i] && i == 6) {
                StartQuestion8(view);
            }
        }
    }

    public void StartTest(View view) {
        Intent activity = new Intent(this, Question0.class);
        startActivity(activity);
    }

    public void StartQuestion2(View view) {
        Intent activity = new Intent(this, Question1.class);
        startActivity(activity);
    }

    public void StartQuestion3(View view) {
        Intent activity = new Intent(this, Question2.class);
        startActivity(activity);
    }

    public void StartQuestion4(View view) {
        Intent activity = new Intent(this, Question3.class);
        startActivity(activity);
    }

    public void StartQuestion5(View view) {
        Intent activity = new Intent(this, Question4.class);
        startActivity(activity);
    }

    public void StartQuestion6(View view) {
        Intent activity = new Intent(this, Question5.class);
        startActivity(activity);
    }

    public void StartQuestion7(View view) {
        Intent activity = new Intent(this, Question6.class);
        startActivity(activity);
    }

    public void StartQuestion8(View view) {
        Intent activity = new Intent(this, Question7.class);
        startActivity(activity);
    }

    public void showResult(View view) {
        Intent activity = new Intent(this, Results.class);
        startActivity(activity);
    }

}
