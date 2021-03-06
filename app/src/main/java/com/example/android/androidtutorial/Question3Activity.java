
package com.example.android.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Question3Activity extends AppCompatActivity {
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
        setContentView(R.layout.activity_question3);
        if (savedInstanceState != null) {
            EditText text = findViewById(R.id.AnsweringArea);
            text.setText(savedInstanceState.getString("answer"));
        }
        MainActivity.currentQuestion=3;
        MainActivity.btnEnabled[1] = true;
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
        //if there's an answer it will start the next activity if not it will show up a warning toast
        String rightanswer = "String .*=\"Awesome\";\nTextView .*=(TextView)findViewById(R.id.Text1);";
        if (submitAnswer()) {
            if (answer.replaceAll("\\s", "").matches(rightanswer.replaceAll("\\s", ""))) {
                MainActivity.rightAnswer[2] = true;
            }
            Intent activity = new Intent(this, Question4Activity.class);
            startActivity(activity);
        } else {
            Toast.makeText(this, "Please write an Answer", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * checks whether there's an answer by getting the value of EditText
     *
     * @return
     */
    boolean submitAnswer() {
        EditText text = (EditText) findViewById(R.id.AnsweringArea);
        String value = text.getText().toString();
        if (value.trim().equals("")) {
            return false;
        } else {
            answer = value;
            return true;
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