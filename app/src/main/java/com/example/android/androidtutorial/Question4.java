package com.example.android.androidtutorial;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;
public class Question4 extends AppCompatActivity {

   public static String answer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question4);
        if (savedInstanceState != null) {
            EditText text = findViewById(R.id.AnsweringArea2);
            text.setText(savedInstanceState.getString("answer"));
        }
        MainActivity.currentQuestion++;
        MainActivity.btnEnabled[3] = true;
        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }
    public void GoHome(View view) {
        Intent activity = new Intent(this, MainActivity.class);
        startActivity(activity);
    }

    public void Next(View view) {
        String rightanswer = "TextView text=findViewById(R.id.TextView);\nString value;\ntext.setText(value);";
        if (SubmitAnswer()) {
            if (answer.replaceAll("\\s","").matches(rightanswer.replaceAll("\\s",""))) {
                MainActivity.RightAnswer[4] = true;
            }
            Intent activity = new Intent(this, Question5.class);
            startActivity(activity);
        } else {
            Toast.makeText(this, "Please choose an Answer", Toast.LENGTH_LONG).show();
        }
    }
    public void pushUp(View view){
        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }

    public void Back(View view) {
        finish();
    }

    boolean SubmitAnswer() {
        EditText text = (EditText) findViewById(R.id.AnsweringArea2);
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
