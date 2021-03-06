package com.example.android.androidtutorial;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Question8Activity extends AppCompatActivity {
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
        setContentView(R.layout.activity_question8);
        if (savedInstanceState != null) {
            EditText text = findViewById(R.id.AnsweringArea4);
            text.setText(savedInstanceState.getString("answer"));
        }
        MainActivity.currentQuestion = 8;
        MainActivity.btnEnabled[6] = true;
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
        String[] rightanswer = {"Button", "ImageView", "TextView"};
        if (submitAnswer()) {
            if (answer.contains(rightanswer[0]) && answer.contains(rightanswer[1]) && answer.contains(rightanswer[2])) {
                MainActivity.rightAnswer[7] = true;
            }
            Intent activity = new Intent(this, ResultsActivity.class);
            startActivity(activity);
        } else {
            Toast.makeText(this, "Please write an Answer", Toast.LENGTH_LONG).show();
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
     * checks whether there's an answer by getting the value of EditText
     *
     * @return true or false
     */

    boolean submitAnswer() {
        EditText text = findViewById(R.id.AnsweringArea4);
        String value = text.getText().toString();
        if (value.trim().replaceAll("\\s", "").equals("")) {
            return false;
        } else {
            answer = value;
            return true;
        }
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
