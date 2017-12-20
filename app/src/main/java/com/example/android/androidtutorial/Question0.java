package com.example.android.androidtutorial;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question0 extends AppCompatActivity {

    public static boolean answer0, answer1, answer2, answer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question0);
        if (savedInstanceState != null) {
            RadioButton[] rb = new RadioButton[]{findViewById(R.id.startActivityForResult),
                    findViewById(R.id.startActivityToResult),
                    findViewById(R.id.Bundle), findViewById(R.id.NoneOfTheAbove)};
            rb[0].setChecked(savedInstanceState.getBoolean("answer0"));
            rb[0].setChecked(savedInstanceState.getBoolean("answer1"));
            rb[0].setChecked(savedInstanceState.getBoolean("answer2"));
            rb[0].setChecked(savedInstanceState.getBoolean("answer3"));
            MainActivity.currentQuestion++;
        }
        MainActivity.continueTest=true;
    }

    public void Next(View view) {
        if (SubmitAnswer()) {
            if (answer1 == true) {
                MainActivity.RightAnswer[0] = true;
            }
            Intent activity = new Intent(this, Question1.class);
            startActivity(activity);
        } else {
            Toast.makeText(this, "Please choose an Answer", Toast.LENGTH_LONG).show();
        }
    }

    public void Back(View view) {
        finish();
    }

    boolean SubmitAnswer() {
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

    // saving the state of the xml document
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