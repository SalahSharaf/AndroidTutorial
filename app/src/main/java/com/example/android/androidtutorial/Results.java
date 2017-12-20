package com.example.android.androidtutorial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        TextView text = findViewById(R.id.ResultTextView);
        int x = 0;
        for (int i = 0; i < MainActivity.RightAnswer.length; i++) {
            if (MainActivity.RightAnswer[i] == true) {
                x++;
            }
        }
        text.setText("" + x + " / 8");
        TypingTask();
        MainActivity.continueTest=false;
        MainActivity.showResult=true;
    }
    public int count=0;
    @Override
    public void onBackPressed(){
        super.onBackPressed();
        count++;
        if(count==2){
            Intent activity=new Intent(this,MainActivity.class);
            startActivity(activity);
        }else{
            Toast.makeText(this,"One More Click to go Home",Toast.LENGTH_LONG).show();
        }
    }

    public void ShowAnswers(View view) {
        ScrollView answersScrollView = findViewById(R.id.Answers);
        answersScrollView.setVisibility(View.VISIBLE);
        view.setVisibility(View.INVISIBLE);
    }

    public void GoTOQuestion0(View view) {
        Intent activity = new Intent(this, Question0.class);
        startActivity(activity);
    }

    public void GoHome(View view) {
        Intent activity = new Intent(this, MainActivity.class);
        startActivity(activity);
    }

    void TypingTask() {
        TextView qanswer0 = findViewById(R.id.question0Answer);
        TextView qanswer1 = findViewById(R.id.question1Answer);
        TextView qanswer2 = findViewById(R.id.question2Answer);
        TextView qanswer3 = findViewById(R.id.question3Answer);
        TextView qanswer4 = findViewById(R.id.question4Answer);
        TextView qanswer5 = findViewById(R.id.question5Answer);
        TextView qanswer6 = findViewById(R.id.question6Answer);
        TextView qanswer7 = findViewById(R.id.question7Answer);
        TextView qRanswer0 = findViewById(R.id.question0RightAnswer);
        TextView qRanswer1 = findViewById(R.id.question1RightAnswer);
        TextView qRanswer2 = findViewById(R.id.question2RightAnswer);
        TextView qRanswer3 = findViewById(R.id.question3RightAnswer);
        TextView qRanswer4 = findViewById(R.id.question4RightAnswer);
        TextView qRanswer5 = findViewById(R.id.question5RightAnswer);
        TextView qRanswer6 = findViewById(R.id.question6RightAnswer);
        TextView qRanswer7 = findViewById(R.id.question7RightAnswer);
        qanswer0.setText("startActivityToResultA = " + Question0.answer0 +
                "\nstartActivityForResult = " + Question0.answer1 +
                "\nBundle=" + Question0.answer2 +
                "\nNone Of The Above = " + Question0.answer3);
        qRanswer0.setText("startActivityForResult = true");
        qanswer1.setText("Collection Of Views And Other Chield Views = " + Question1.answer0 +
                "\nBaseClassOfBuildingBlocks = " + Question1.answer1 +
                "\nLayouts = " + Question1.answer2 +
                "\nNoneOfTheAbove2 = " + Question1.answer3);
        qRanswer1.setText("Collection Of Views And Other Chield Views = true");
        qanswer2.setText(Question2.answer);
        qRanswer2.setText("String var = Awesome;\nTextView text=(TextView)findViewById(R.id.Text1);)");
        qanswer3.setText("LinearLayout = " + Question3.answer0 +
                "\nImageView = " + Question3.answer1 +
                "\nRelativeLayout = " + Question3.answer2 +
                "\nTextView = " + Question3.answer3);
        qRanswer3.setText("LinearLayout = true\nRelativeLayout = true");
        qanswer4.setText(Question4.answer);
        qRanswer4.setText("TextView text=findViewById(R.id.TextView);\nString value;\ntext.setText(value);");
        qanswer5.setText(Question5.answer);
        qRanswer5.setText("15");
        qanswer6.setText("layout_width = " + Question6.answer0 +
                "\npadding = " + Question6.answer1 +
                "\nlayout_height = " + Question6.answer2 +
                "\ntext = " + Question6.answer3);
        qRanswer6.setText("layout_height = true\nlayout_width = true");
        qanswer7.setText(Question7.answer);
        qRanswer7.setText("Button,TextView,ImageView");
    }
}