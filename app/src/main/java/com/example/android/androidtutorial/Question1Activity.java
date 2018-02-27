package com.example.android.androidtutorial;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question1Activity extends AppCompatActivity {
    // each variable of these contains the value of each radio buttons
    public static boolean answer0, answer1, answer2, answer3;

    /**
     * initialize an array of radio buttons and restore the saved state
     * and increase currentQuestion variable by one
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        if (savedInstanceState != null) {
            RadioButton[] rb = new RadioButton[]{findViewById(R.id.startActivityForResult),
                    findViewById(R.id.startActivityToResult),
                    findViewById(R.id.Bundle), findViewById(R.id.NoneOfTheAbove)};
            rb[0].setChecked(savedInstanceState.getBoolean("answer0"));
            rb[0].setChecked(savedInstanceState.getBoolean("answer1"));
            rb[0].setChecked(savedInstanceState.getBoolean("answer2"));
            rb[0].setChecked(savedInstanceState.getBoolean("answer3"));
        }
        MainActivity.currentQuestion = 1;
    }

    /**
     * first this function checks whither there's an input by calling submitAnswer() function
     * --if true then start the next activity
     * then check the answer itself if true then it's variable in the main activity is assigned to true inside it's array
     * --if false show up a toast saying "Please choose an Answer"
     * @param view
     */

    public void next(View view) {
        if (submitAnswer()) {
            if (answer1 == true) {
                MainActivity.rightAnswer[0] = true;
            }
            Intent activity = new Intent(this, Question2Activity.class);
            startActivity(activity);
        } else {
            Toast.makeText(this, "Please choose an Answer", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * this function closes the current question and go to the previous one
     *
     * @param view
     */

    public void back(View view) {
        Intent activity =new Intent(this,MainActivity.class);
        startActivity(activity);
    }

    /**
     * checks whether there's an answer by getting the value of each radio button
     *
     * @return
     */
    boolean submitAnswer() {
        RadioButton[] rb = new RadioButton[]{findViewById(R.id.startActivityForResult),
                findViewById(R.id.startActivityToResult),
                findViewById(R.id.Bundle), findViewById(R.id.NoneOfTheAbove)};
        if (rb[0].isChecked()) {
            answer0 = true;
            return true;
        } else if (rb[1].isChecked()) {
            answer1 = true;
            return true;
        } else if (rb[2].isChecked()) {
            answer2 = true;
            return true;
        } else if (rb[3].isChecked()) {
            answer3 = true;
            return true;
        } else if (!rb[0].isChecked() && !rb[1].isChecked() && !rb[2].isChecked() && !rb[3].isChecked()) {
            return false;
        }
        return true;
    }

    /**
     * saves the current state of the activity
     * in this case i will save the value of radio buttons
     *
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putBoolean("answer0", answer0);
        outState.putBoolean("answer1", answer0);
        outState.putBoolean("answer2", answer0);
        outState.putBoolean("answer3", answer0);
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);

    }
}