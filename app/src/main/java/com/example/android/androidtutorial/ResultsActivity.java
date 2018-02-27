package com.example.android.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {
    /**
     * checks the number of right answers
     * calling typingTask function to display answers and the right ones
     * disabling continue button by setting continueTask variable in the maiin activity to false
     * enabling Show Result button in the main activity by setting showResult variable to true
     *
     * @param savedInstanceState
     */
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        TextView text = findViewById(R.id.ResultTextView);
        int x = 0;
        for (int i = 0; i < MainActivity.rightAnswer.length; i++) {
            if (MainActivity.rightAnswer[i] == true) {
                x++;
            }
        }

        text.setText("" + x + " / 8");
        typingTask();
        MainActivity.continueTest = false;
        MainActivity.showResult = true;
    }

    /**
     * this function get the back button pressed times in the count variable
     * if one show up toast to display a message
     * if count reaches 2 then go home to the main activity
     */

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // this integer variable contains the number of clicks
        count++;
        if (count == 2) {
            Intent activity = new Intent(this, MainActivity.class);
            startActivity(activity);
        } else {
            Toast.makeText(this, "One More Click to go Home", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * show answers which were set to be invisible inside a ScrollView
     *
     * @param view
     */

    public void showAnswers(View view) {
        ScrollView answersScrollView = findViewById(R.id.Answers);
        answersScrollView.setVisibility(View.VISIBLE);
        view.setVisibility(View.INVISIBLE);
    }

    /**
     * go to the first question
     * and resets all public static variables in the app to null
     * in order to start a new test
     *
     * @param view
     */
    public void goToQuestion1(View view) {
        MainActivity.currentQuestion = 0;
        MainActivity.continueTest = false;
        for (int i = 0; i > MainActivity.rightAnswer.length; i++)
            MainActivity.rightAnswer[i] = false;
        for (int i = 0; i < MainActivity.btnEnabled.length; i++)
            MainActivity.btnEnabled[i] = false;
        MainActivity.showResult = false;
        Question1Activity.answer0 = false;
        Question1Activity.answer1 = false;
        Question1Activity.answer2 = false;
        Question1Activity.answer3 = false;
        Question2Activity.answer0 = false;
        Question2Activity.answer1 = false;
        Question2Activity.answer2 = false;
        Question2Activity.answer3 = false;
        Question3Activity.answer = "";
        Question4Activity.answer0 = false;
        Question4Activity.answer1 = false;
        Question4Activity.answer2 = false;
        Question4Activity.answer3 = false;
        Question5Activity.answer = "";
        Question6Activity.answer = "";
        Question7Activity.answer0 = false;
        Question7Activity.answer1 = false;
        Question7Activity.answer2 = false;
        Question7Activity.answer3 = false;
        Question8Activity.answer = "";
        Intent activity = new Intent(this, Question1Activity.class);
        startActivity(activity);
    }

    /**
     * go to main activity
     *
     * @param view
     */
    public void goHome(View view) {
        Intent activity = new Intent(this, MainActivity.class);
        startActivity(activity);
    }

    /**
     * initialize all TextViews in the hidden scrollView and set there text to the user answer followed by the right one
     */
    void typingTask() {
        //initializing TextViews
        TextView[] qanswer = new TextView[8];
        TextView[] qRanswer = new TextView[8];
        qanswer[0] = findViewById(R.id.question1Answer);
        qanswer[1] = findViewById(R.id.question2Answer);
        qanswer[2] = findViewById(R.id.question3Answer);
        qanswer[3] = findViewById(R.id.question4Answer);
        qanswer[4] = findViewById(R.id.question5Answer);
        qanswer[5] = findViewById(R.id.question6Answer);
        qanswer[6] = findViewById(R.id.question7Answer);
        qanswer[7] = findViewById(R.id.question8Answer);
        qRanswer[0] = findViewById(R.id.question1RightAnswer);
        qRanswer[1] = findViewById(R.id.question2RightAnswer);
        qRanswer[2] = findViewById(R.id.question3RightAnswer);
        qRanswer[3] = findViewById(R.id.question4RightAnswer);
        qRanswer[4] = findViewById(R.id.question5RightAnswer);
        qRanswer[5] = findViewById(R.id.question6RightAnswer);
        qRanswer[6] = findViewById(R.id.question7RightAnswer);
        qRanswer[7] = findViewById(R.id.question8RightAnswer);
        //////////////////////////////////////////////////////////////////////
        int color = getResources().getColor(R.color.AnswerRight);
        for (int i = 0; i < MainActivity.rightAnswer.length; i++) {
            if (MainActivity.rightAnswer[i] == true) {
                qanswer[i].setTextColor(color);
            }
        }
        qanswer[0].append("startActivityToResultA = " + Question1Activity.answer0 +
                "\nstartActivityForResult = " + Question1Activity.answer1 +
                "\nBundle = " + Question1Activity.answer2 +
                "\nNone Of The Above = " + Question1Activity.answer3);
        qRanswer[0].append("startActivityForResult = true");
        qanswer[1].append("Collection Of Views And Other Chield Views = " + Question2Activity.answer0 +
                "\nBaseClassOfBuildingBlocks = " + Question2Activity.answer1 +
                "\nLayouts = " + Question2Activity.answer2 +
                "\nNoneOfTheAbove2 = " + Question2Activity.answer3);
        qRanswer[1].append("Collection Of Views And Other Chield Views = true");
        qanswer[2].append(Question3Activity.answer);
        qRanswer[2].append("String var = Awesome;\nTextView text=(TextView)findViewById(R.id.Text1);");
        qanswer[3].append("LinearLayout = " + Question4Activity.answer0 + "\nImageView = " +
                Question4Activity.answer1 +
                "\nRelativeLayout = " + Question4Activity.answer2 +
                "\nTextView = " + Question4Activity.answer3);
        qRanswer[3].append("LinearLayout = true\nRelativeLayout = true");
        qanswer[4].append(Question5Activity.answer);
        qRanswer[4].append("TextView text=findViewById(R.id.TextView);\nString value;\ntext.setText(value);");
        qanswer[5].append(Question6Activity.answer);
        qRanswer[5].append("15");
        qanswer[6].append("layout_width = " + Question7Activity.answer0 +
                "\npadding = " + Question7Activity.answer1 +
                "\nlayout_height = " + Question7Activity.answer2 +
                "\ntext = " + Question7Activity.answer3);
        qRanswer[6].append("layout_height = true\nlayout_width = true");
        qanswer[7].append(Question8Activity.answer);
        qRanswer[7].append("Button,TextView,ImageView");
    }
}