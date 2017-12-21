package com.example.android.androidtutorial;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Question6 extends AppCompatActivity {
    // this string variable contains the value of the answer
    public static String answer;

    /**
     * restore the saved state
     * and increase currentQuestion variable by one and enable this question button in the main activity by enabling btnEnabled variable in the main activity
     *
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question6);
        if (savedInstanceState != null) {
            EditText text = findViewById(R.id.AnsweringArea3);
            text.setText(savedInstanceState.getString("answer"));
        }
        MainActivity.currentQuestion=6;
        MainActivity.btnEnabled[4] = true;
    }

    /**
     * go to the main activity
     *
     * @param view
     */
    public void GoHome(View view) {
        Intent activity = new Intent(this, MainActivity.class);
        startActivity(activity);
    }

    /**
     * first this function checks whither there's an input by calling SubmitAnswer() function
     * --if true then start the next activity
     * then check the answer itself if true then it's variable in the main activity is assigned to true inside it's array
     * --if false show up a toast saying "Please choose an Answer"
     *
     * @param view
     */

    public void Next(View view) {
        String rightanswwr = "15";
        if (SubmitAnswer()) {
            if (answer.trim().matches(rightanswwr.trim())) {
                MainActivity.rightAnswer[5] = true;
            }
            Intent activity = new Intent(this, Question7.class);
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
    public void Back(View view) {
        finish();
    }

    /**
     * checks whether there's an answer by getting the value of EditText
     *
     * @return
     */
    boolean SubmitAnswer() {
        EditText text = findViewById(R.id.AnsweringArea3);
        String value = text.getText().toString();
        if (value.replaceAll("\\s","").equals("")) {
            return false;
        } else {
            answer = value;
            return true;
        }
    }

    /**
     * saves the current state of the activity
     * in this case i will save the value of answer
     *
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("answer", answer);
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }
}
