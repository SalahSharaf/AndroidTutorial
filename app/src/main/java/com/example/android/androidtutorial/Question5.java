package com.example.android.androidtutorial;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;
public class Question5 extends AppCompatActivity {

   public static String answer;

    /**
     * restore the saved state
     * and increase currentQuestion variable by one and enable this question button in the main activity by enabling btnEnabled variable in the main activity
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question5);
        if (savedInstanceState != null) {
            EditText text = findViewById(R.id.AnsweringArea2);
            text.setText(savedInstanceState.getString("answer"));
        }else if(savedInstanceState==null) {
            MainActivity.currentQuestion++;
        }
        MainActivity.btnEnabled[3] = true;
    }
    /**
     * go to the main activity
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
     * @param view
     */
    public void Next(View view) {
        String rightanswer = "TextView text=findViewById(R.id.TextView);\nString value;\ntext.setText(value);";
        if (SubmitAnswer()) {
            if (answer.replaceAll("\\s","").matches(rightanswer.replaceAll("\\s",""))) {
                MainActivity.rightAnswer[4] = true;
            }
            Intent activity = new Intent(this, Question6.class);
            startActivity(activity);
        } else {
            Toast.makeText(this, "Please choose an Answer", Toast.LENGTH_LONG).show();
        }
    }
    public void pushUp(View view){
        this.getWindow().setSoftInputMode(
                WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
    }
    /**
     * this function closes the current question and go to the previous one
     * @param view
     */
    public void Back(View view) {
        finish();
    }
    /**
     * checks whether there's an answer by getting the value of each radio button
     * @return
     */
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
    /**
     * saves the current state of the activity
     * in this case i will save the value of radio buttons
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        outState.putString("answer", answer);
        // call superclass to save any view hierarchy
        super.onSaveInstanceState(outState);
    }
}
