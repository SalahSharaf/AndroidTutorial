package com.example.android.androidtutorial;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

public class Question7 extends AppCompatActivity {

    public  static String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question7);
        if (savedInstanceState != null) {
            EditText text = findViewById(R.id.AnsweringArea4);
            text.setText(savedInstanceState.getString("answer"));
        }
        MainActivity.currentQuestion++;
        MainActivity.btnEnabled[6] = true;
    }

    public void Next(View view) {
        String[] rightanswer = {"Button", "ImageView", "TextView"};
        if (SubmitAnswer()) {
            if (answer.contains(rightanswer[0]) && answer.contains(rightanswer[1]) && answer.contains(rightanswer[2])) {
                MainActivity.RightAnswer[7] = true;
            }
            Intent activity = new Intent(this, Results.class);
            startActivity(activity);
        } else {
            Toast.makeText(this, "Please write an Answer", Toast.LENGTH_LONG).show();
        }
    }

    public void Back(View view) {
        finish();
    }

    boolean SubmitAnswer() {
        EditText text = findViewById(R.id.AnsweringArea4);
        String value = text.getText().toString();
        if (value.trim().equals("")) {
            return false;
        } else {
            answer = value;
            return true;
        }
    }
    public void GoHome(View view) {
        Intent activity = new Intent(this, MainActivity.class);
        startActivity(activity);
    }

    // saving the state of the xml document
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("answer", answer);
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }
}
