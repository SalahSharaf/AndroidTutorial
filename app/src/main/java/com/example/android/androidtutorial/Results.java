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
        // this integer variable contains the number of clicked
        int count = 0;
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
     * @param view
     */
    public void ShowAnswers(View view) {
        ScrollView answersScrollView = findViewById(R.id.Answers);
        answersScrollView.setVisibility(View.VISIBLE);
        view.setVisibility(View.INVISIBLE);
    }

    /**
     * go to the first question
     * @param view
     */
    public void GoTOQuestion1(View view) {
        Intent activity = new Intent(this, Question1.class);
        startActivity(activity);
    }

    /**
     * go to main activity
     * @param view
     */
    public void GoHome(View view) {
        Intent activity = new Intent(this, MainActivity.class);
        startActivity(activity);
    }

    /**
     * initialize all TextViews in the hidden scrollView and set there text to the user answer followed by the right one
     *
     */
    void TypingTask() {
        TextView qanswer1 = findViewById(R.id.question1Answer);
        TextView qanswer2 = findViewById(R.id.question2Answer);
        TextView qanswer3 = findViewById(R.id.question3Answer);
        TextView qanswer4 = findViewById(R.id.question4Answer);
        TextView qanswer5 = findViewById(R.id.question5Answer);
        TextView qanswer6 = findViewById(R.id.question6Answer);
        TextView qanswer7 = findViewById(R.id.question7Answer);
        TextView qanswer8 = findViewById(R.id.question8Answer);
        TextView qRanswer1 = findViewById(R.id.question1RightAnswer);
        TextView qRanswer2 = findViewById(R.id.question2RightAnswer);
        TextView qRanswer3 = findViewById(R.id.question3RightAnswer);
        TextView qRanswer4 = findViewById(R.id.question4RightAnswer);
        TextView qRanswer5 = findViewById(R.id.question5RightAnswer);
        TextView qRanswer6 = findViewById(R.id.question6RightAnswer);
        TextView qRanswer7 = findViewById(R.id.question7RightAnswer);
        TextView qRanswer8 = findViewById(R.id.question8RightAnswer);
        qanswer1.setText("startActivityToResultA = " + Question1.answer0 +
                "\nstartActivityForResult = " + Question1.answer1 +
                "\nBundle=" + Question1.answer2 +
                "\nNone Of The Above = " + Question1.answer3);
        qRanswer1.setText("startActivityForResult = true");
        qanswer2.setText("Collection Of Views And Other Chield Views = " + Question2.answer0 +
                "\nBaseClassOfBuildingBlocks = " + Question2.answer1 +
                "\nLayouts = " + Question2.answer2 +
                "\nNoneOfTheAbove2 = " + Question2.answer3);
        qRanswer2.setText("Collection Of Views And Other Chield Views = true");
        qanswer3.setText(Question3.answer);
        qRanswer3.setText("String var = Awesome;\nTextView text=(TextView)findViewById(R.id.Text1);)");
        qanswer4.setText("LinearLayout = " + Question4.answer0 +
                "\nImageView = " + Question4.answer1 +
                "\nRelativeLayout = " + Question4.answer2 +
                "\nTextView = " + Question4.answer3);
        qRanswer4.setText("LinearLayout = true\nRelativeLayout = true");
        qanswer5.setText(Question5.answer);
        qRanswer5.setText("TextView text=findViewById(R.id.TextView);\nString value;\ntext.setText(value);");
        qanswer6.setText(Question6.answer);
        qRanswer6.setText("15");
        qanswer7.setText("layout_width = " + Question7.answer0 +
                "\npadding = " + Question7.answer1 +
                "\nlayout_height = " + Question7.answer2 +
                "\ntext = " + Question7.answer3);
        qRanswer7.setText("layout_height = true\nlayout_width = true");
        qanswer8.setText(Question8.answer);
        qRanswer8.setText("Button,TextView,ImageView");
    }
}