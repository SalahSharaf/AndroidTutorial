package com.example.android.androidtutorial;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class Question5 extends AppCompatActivity {

    public static String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        if (savedInstanceState != null) {
            EditText text = findViewById(R.id.AnsweringArea3);
            text.setText(savedInstanceState.getString("answer"));
        }
        MainActivity.currentQuestion++;
        MainActivity.btnEnabled[4] = true;
    }
    public void GoHome(View view) {
        Intent activity = new Intent(this, MainActivity.class);
        startActivity(activity);
    }

    public void Next(View view) {
        String rightanswwr = "15";
        if (SubmitAnswer()) {
            if (answer.trim().matches(rightanswwr.trim())) {
                MainActivity.RightAnswer[5] = true;
            }
            Intent activity = new Intent(this, Question6.class);
            startActivity(activity);
        } else {
            Toast.makeText(this, "Please choose an Answer", Toast.LENGTH_LONG).show();
        }
    }

    public void Back(View view) {
        finish();
    }

    boolean SubmitAnswer() {
        EditText text = findViewById(R.id.AnsweringArea3);
        String value = text.getText().toString();
        if (value.trim().equals("")) {
            return false;
        } else {
            answer = value;
            return true;
        }
    }

    // saving the state of the xml document
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("answer", answer);
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }
}
