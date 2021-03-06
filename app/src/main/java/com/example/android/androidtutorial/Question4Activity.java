package com.example.android.androidtutorial;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class Question4Activity extends AppCompatActivity {
    // each variable of these contains the value of each radio buttons
    public static boolean answer0, answer1, answer2, answer3;

    /**
     * restore the saved state
     * and increase currentQuestion variable by one and enable this question button in the main activity by enabling btnEnabled variable in the main activity
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        if (savedInstanceState != null) {
            CheckBox[] rb = new CheckBox[]{findViewById(R.id.LinearLayout),
                    findViewById(R.id.ImageView),
                    findViewById(R.id.RelativeLayout), findViewById(R.id.TextView)};
            rb[0].setChecked(savedInstanceState.getBoolean("answer0"));
            rb[1].setChecked(savedInstanceState.getBoolean("answer1"));
            rb[2].setChecked(savedInstanceState.getBoolean("answer2"));
            rb[3].setChecked(savedInstanceState.getBoolean("answer3"));
        }
        MainActivity.currentQuestion=4;
        MainActivity.btnEnabled[2] = true;
    }

    /**
     * go to the main activity
     *
     * @param view
     */
    public void goHome(View view) {
        Intent activity = new Intent(this, MainActivity.class);
        startActivity(activity);
    }

    /**
     * first this function checks whither there's an input by calling submitAnswer() function
     * --if true then start the next activity
     * then check the answer itself if true then it's variable in the main activity is assigned to true inside it's array
     * --if false show up a toast saying "Please choose an Answer"
     *
     * @param view
     */
    public void next(View view) {
        if (submitAnswer()) {
            if (answer0 == true && answer2 == true) {
                MainActivity.rightAnswer[3] = true;
            }
            Intent activity = new Intent(this, Question5Activity.class);
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
        finish();
    }

    /**
     * checks whether there's an answer by getting the value of each radio button
     *
     * @return
     */
    boolean submitAnswer() {
        CheckBox[] rb = new CheckBox[]{findViewById(R.id.LinearLayout),
                findViewById(R.id.ImageView),
                findViewById(R.id.RelativeLayout), findViewById(R.id.TextView)};
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
     * in this case i will save the value of CheckBoxes
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
