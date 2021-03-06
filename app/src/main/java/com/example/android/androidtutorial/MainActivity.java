package com.example.android.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    /**
     * here i have made global variables to be used in all the document
     */

    // this variable identify the current question the user answers now
    public static int currentQuestion = 0;
    // these are for the button show Result and continuing test button in the main activity to enable them in the right time
    public static boolean continueTest, showResult;
    // controls buttons availability to enable the right button for the current question which user answers now they are 7 because the first question's button is already enabled
    public static boolean[] btnEnabled = new boolean[7];
    // an array of booleans to check every question answer right or wrong
    public static boolean[] rightAnswer = new boolean[8];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initializing questions buttons array and TextViews
        Button[] btnsEnabled = new Button[7];
        btnsEnabled[0] = findViewById(R.id.question2Button);
        btnsEnabled[1] = findViewById(R.id.question3Button);
        btnsEnabled[2] = findViewById(R.id.question4Button);
        btnsEnabled[3] = findViewById(R.id.question5Button);
        btnsEnabled[4] = findViewById(R.id.question6Button);
        btnsEnabled[5] = findViewById(R.id.question7Button);
        btnsEnabled[6] = findViewById(R.id.question8Button);
        TextView text = findViewById(R.id.AnswersMessage);
        int previousQuestion = currentQuestion - 1;
        if (previousQuestion < 0) {
            previousQuestion = 0;
        }
        String message = getString(R.string._0_of_8_questions_have_been_answered, (previousQuestion) + " ");
        Button btnContiue = findViewById(R.id.continueTest);
        Button btnShowReslut = findViewById(R.id.resultButton);
        TextView text2 = findViewById(R.id.CurrentQuestion);
        ////////////////////////////////////////////////////////////////////////////////////////////////////
        if (savedInstanceState != null) {
            currentQuestion = savedInstanceState.getInt("currentQuestion");
            continueTest = savedInstanceState.getBoolean("continueTest");
            showResult = savedInstanceState.getBoolean("showResult");
            btnEnabled = savedInstanceState.getBooleanArray("btnEnabled");
            rightAnswer = savedInstanceState.getBooleanArray("rightAnswer");
        }
        for (int i = 0; i < btnsEnabled.length; i++) {
            btnsEnabled[i].setEnabled(btnEnabled[i]);
        }
        if (continueTest) {
            text2.setVisibility(View.VISIBLE);
            btnContiue.setVisibility(View.VISIBLE);
        } else if (!continueTest) {
            text2.setVisibility(View.INVISIBLE);
            btnContiue.setVisibility(View.INVISIBLE);
        }
        text2.setText("Question " + currentQuestion);
        text.setText(message);
        btnShowReslut.setEnabled(showResult);
        animationsTask();
    }

    /**
     * this function is responsible for the animation starts with the application
     * first initializes the cards which will be animated withen an array Cards
     * the making an array of animations and the point will be that i wanna control the delay time of each one
     * for loop is responsible to assign values by id
     * and increasing the delay time every time
     */
    void animationsTask() {
        //initializing cards array
        CardView[] cards = new CardView[8];
        // this variable identify the initial value for the time
        int duration = 1500;
        Animation[] animStart = new Animation[8];
        cards[0] = findViewById(R.id.question1);
        cards[1] = findViewById(R.id.question2);
        cards[2] = findViewById(R.id.question3);
        cards[3] = findViewById(R.id.question4);
        cards[4] = findViewById(R.id.question5);
        cards[5] = findViewById(R.id.question6);
        cards[6] = findViewById(R.id.question7);
        cards[7] = findViewById(R.id.question8);
        ////////////////////////////////////////////////////////////////////////
        for (int i = 0; i < cards.length; i++) {
            animStart[i] = AnimationUtils.loadAnimation(this, R.anim.startinganimation);
            animStart[i].setDuration(duration + 200 * i);
            cards[i].startAnimation(animStart[i]);
        }
    }

    /**
     * this function continue the current question depending on the value of the variable currentQuestion
     * i didn't check the currentQuestion variable for value 1 because the button continue will not be enabled till the currentQuestion value be 2
     *
     * @param view this for the button continuing
     */

    public void continuing(View view) {

        if (currentQuestion == 2) {
            startQuestion2(view);
        } else if (currentQuestion == 3) {
            startQuestion3(view);
        } else if (currentQuestion == 4) {
            startQuestion4(view);
        } else if (currentQuestion == 5) {
            startQuestion5(view);
        } else if (currentQuestion == 6) {
            startQuestion6(view);
        } else if (currentQuestion == 7) {
            startQuestion7(view);
        } else if (currentQuestion == 8) {
            startQuestion8(view);
        }

    }

    /**
     * starts Question 1
     *
     * @param view
     */

    public void startTest(View view) {
        Intent activity = new Intent(this, Question1Activity.class);
        startActivity(activity);
    }

    /**
     * starts Question 2
     *
     * @param view
     */
    public void startQuestion2(View view) {
        Intent activity = new Intent(this, Question2Activity.class);
        startActivity(activity);
    }

    /**
     * starts Question 3
     *
     * @param view
     */
    public void startQuestion3(View view) {
        Intent activity = new Intent(this, Question3Activity.class);
        startActivity(activity);
    }

    /**
     * starts Question 4
     *
     * @param view
     */
    public void startQuestion4(View view) {
        Intent activity = new Intent(this, Question4Activity.class);
        startActivity(activity);
    }

    /**
     * starts Question 5
     *
     * @param view
     */
    public void startQuestion5(View view) {
        Intent activity = new Intent(this, Question5Activity.class);
        startActivity(activity);
    }

    /**
     * starts Question 6
     *
     * @param view
     */
    public void startQuestion6(View view) {
        Intent activity = new Intent(this, Question6Activity.class);
        startActivity(activity);
    }

    /**
     * starts Question 7
     *
     * @param view
     */
    public void startQuestion7(View view) {
        Intent activity = new Intent(this, Question7Activity.class);
        startActivity(activity);
    }

    /**
     * starts Question 8
     *
     * @param view
     */
    public void startQuestion8(View view) {
        Intent activity = new Intent(this, Question8Activity.class);
        startActivity(activity);
    }

    /**
     * starts Result page
     *
     * @param view
     */
    public void showResult(View view) {
        Intent activity = new Intent(this, ResultsActivity.class);
        startActivity(activity);
    }

    /**
     * saves the current state of the activity
     * in this case i will save the value of the global variables
     *
     * @param outState
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("currentQuestion", currentQuestion);
        outState.getBoolean("showResult", showResult);
        outState.getBoolean("continueTest", continueTest);
        outState.putBooleanArray("btnEnabled", btnEnabled);
        outState.putBooleanArray("rightAnswer", rightAnswer);
        super.onSaveInstanceState(outState);
    }
}
