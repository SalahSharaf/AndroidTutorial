package com.example.android.androidtutorial;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.Toast;

public class Question3 extends AppCompatActivity {

    public  static boolean answer0, answer1, answer2, answer3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question3);
        if(savedInstanceState!=null){
            CheckBox[] rb = new CheckBox[]{findViewById(R.id.LinearLayout),
                    findViewById(R.id.ImageView),
                    findViewById(R.id.RelativeLayout), findViewById(R.id.TextView)};
            rb[0].setChecked(savedInstanceState.getBoolean("answer0"));
            rb[1].setChecked(savedInstanceState.getBoolean("answer1"));
            rb[2].setChecked(savedInstanceState.getBoolean("answer2"));
            rb[3].setChecked(savedInstanceState.getBoolean("answer3"));
        }
        MainActivity.currentQuestion++;
        MainActivity.btnEnabled[2]=true;
    }
    public void GoHome(View view) {
        Intent activity = new Intent(this, MainActivity.class);
        startActivity(activity);
    }

    public void Next(View view) {
        if (SubmitAnswer()) {
            if(answer0==true&&answer2==true){
                MainActivity.RightAnswer[3]=true;
            }
            Intent activity = new Intent(this, Question4.class);
            startActivity(activity);
        } else {
            Toast.makeText(this, "Please choose an Answer", Toast.LENGTH_LONG).show();
        }
    }

    public void Back(View view) {
        finish();
    }

    boolean SubmitAnswer() {
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