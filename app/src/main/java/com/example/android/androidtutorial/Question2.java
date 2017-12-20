
package com.example.android.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class Question2 extends AppCompatActivity {

    public static String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);
        if (savedInstanceState != null) {
            EditText text = findViewById(R.id.AnsweringArea);
            text.setText(savedInstanceState.getString("answer"));
        }
        MainActivity.currentQuestion++;
        MainActivity.btnEnabled[1] = true;
    }
    public void GoHome(View view) {
        Intent activity = new Intent(this, MainActivity.class);
        startActivity(activity);
    }

    public void Next(View view) {
        //if there's an answer it will start the next activity if not it will show up a warning toast
        String rightanswer="String (.*)=\"Awesome\";(\n| )TextView (.*)=(TextView)findViewById(R.id.Text1);";
        if (SubmitAnswer()) {
            if (answer.replaceAll("\\s","").matches(rightanswer.replaceAll("\\s",""))) {
                MainActivity.RightAnswer[2] = true;
            }
            Intent activity = new Intent(this, Question3.class);
            startActivity(activity);
        } else {
            Toast.makeText(this, "Please write an Answer", Toast.LENGTH_LONG).show();
        }
    }

    // check if there's an answer
    boolean SubmitAnswer() {
        EditText text = (EditText) findViewById(R.id.AnsweringArea);
        String value = text.getText().toString();
        if (value.trim().equals("")) {
            return false;
        } else {
            answer = value;
            return true;
        }
    }

    public void Back(View view) {
        finish();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("answer", answer);
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);

    }
}