package com.example.android.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.Toast;

public class Question1 extends AppCompatActivity {

    public static boolean answer0, answer1, answer2, answer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question1);
        //checking if the value is null for the first call
        if(savedInstanceState!=null){
            RadioButton[] rb = new RadioButton[]{findViewById(R.id.CollectionOfViewsAndOtherChieldViews),
                    findViewById(R.id.BaseClassOfBuildingBlocks),
                    findViewById(R.id.Layouts), findViewById(R.id.NoneOfTheAbove2)};
            rb[0].setChecked(savedInstanceState.getBoolean("answer0"));
            rb[0].setChecked(savedInstanceState.getBoolean("answer1"));
            rb[0].setChecked(savedInstanceState.getBoolean("answer2"));
            rb[0].setChecked(savedInstanceState.getBoolean("answer3"));
        }
        MainActivity.currentQuestion++;
        MainActivity.btnEnabled[0]=true;
        MainActivity.continueTest=true;
    }
    public void GoHome(View view) {
        Intent activity = new Intent(this, MainActivity.class);
        startActivity(activity);
    }

    public void Next(View view) {
        if (SubmitAnswer()) {
            if(answer0==true) {
                MainActivity.RightAnswer[1]=true;
            }
            Intent activity = new Intent(this, Question2.class);
            startActivity(activity);
        } else {
            Toast.makeText(this, "Please choose an Answer", Toast.LENGTH_LONG).show();
        }
    }

    public void Back(View view) {
        finish();
    }

    boolean SubmitAnswer() {
        RadioButton[] rb = new RadioButton[]{findViewById(R.id.CollectionOfViewsAndOtherChieldViews),
                findViewById(R.id.BaseClassOfBuildingBlocks),
                findViewById(R.id.Layouts), findViewById(R.id.NoneOfTheAbove2)};
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
        outState.putBoolean("answer0",answer0);
        outState.putBoolean("answer1",answer0);
        outState.putBoolean("answer2",answer0);
        outState.putBoolean("answer3",answer0);
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }
}
