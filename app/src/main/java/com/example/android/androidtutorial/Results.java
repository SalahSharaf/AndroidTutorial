package com.example.android.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends AppCompatActivity {
    /**
     * checks the number of right answers
     * calling TypingTask function to display answers and the right ones
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
        TypingTask();
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
    public void ShowAnswers(View view) {
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
    public void GoTOQuestion1(View view) {
        MainActivity.currentQuestion = 0;
        MainActivity.continueTest = false;
        for (int i = 0; i > MainActivity.rightAnswer.length; i++)
            MainActivity.rightAnswer[i] = false;
        for (int i = 0; i < MainActivity.btnEnabled.length; i++)
            MainActivity.btnEnabled[i] = false;
        MainActivity.showResult = false;
        Question1.answer0 = false;
        Question1.answer1 = false;
        Question1.answer2 = false;
        Question1.answer3 = false;
        Question2.answer0 = false;
        Question2.answer1 = false;
        Question2.answer2 = false;
        Question2.answer3 = false;
        Question3.answer = "";
        Question4.answer0 = false;
        Question4.answer1 = false;
        Question4.answer2 = false;
        Question4.answer3 = false;
        Question5.answer = "";
        Question6.answer = "";
        Question7.answer0 = false;
        Question7.answer1 = false;
        Question7.answer2 = false;
        Question7.answer3 = false;
        Question8.answer = "";
        Intent activity = new Intent(this, Question1.class);
        startActivity(activity);
    }

    /**
     * go to main activity
     *
     * @param view
     */
    public void GoHome(View view) {
        Intent activity = new Intent(this, MainActivity.class);
        startActivity(activity);
    }

    /**
     * initialize all TextViews in the hidden scrollView and set there text to the user answer followed by the right one
     */
    void TypingTask() {
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
        qanswer[0].setText("startActivityToResultA = " + Question1.answer0 +
                "\nstartActivityForResult = " + Question1.answer1 +
                "\nBundle=" + Question1.answer2 +
                "\nNone Of The Above = " + Question1.answer3);
        qRanswer[0].setText("startActivityForResult = true");
        qanswer[1].setText("Collection Of Views And Other Chield Views = " + Question2.answer0 +
                "\nBaseClassOfBuildingBlocks = " + Question2.answer1 +
                "\nLayouts = " + Question2.answer2 +
                "\nNoneOfTheAbove2 = " + Question2.answer3);
        qRanswer[1].setText("Collection Of Views And Other Chield Views = true");
        qanswer[2].setText(Question3.answer);
        qRanswer[2].setText("String var = Awesome;\nTextView text=(TextView)findViewById(R.id.Text1);)");
        qanswer[3].setText("LinearLayout = " + Question4.answer0 +
                "\nImageView = " + Question4.answer1 +
                "\nRelativeLayout = " + Question4.answer2 +
                "\nTextView = " + Question4.answer3);
        qRanswer[3].setText("LinearLayout = true\nRelativeLayout = true");
        qanswer[4].setText(Question5.answer);
        qRanswer[4].setText("TextView text=findViewById(R.id.TextView);\nString value;\ntext.setText(value);");
        qanswer[5].setText(Question6.answer);
        qRanswer[5].setText("15");
        qanswer[6].setText("layout_width = " + Question7.answer0 +
                "\npadding = " + Question7.answer1 +
                "\nlayout_height = " + Question7.answer2 +
                "\ntext = " + Question7.answer3);
        qRanswer[6].setText("layout_height = true\nlayout_width = true");
        qanswer[7].setText(Question8.answer);
        qRanswer[7].setText("Button,TextView,ImageView");
    }
}