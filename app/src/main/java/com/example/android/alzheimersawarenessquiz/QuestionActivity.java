package com.example.android.alzheimersawarenessquiz;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {

    private TextView userName;
    private TextView questionNumberText;
    private TextView questionText;
    private CheckBox answerExample1;
    private CheckBox answerExample2;
    private CheckBox answerExample3;
    private CheckBox answerExample4;
    private CheckBox answerNone;

    //create variable for user's name
    String name;

    //create variables for score and point
    final int POINT = 1;
    int score = 0;

    //declare an array of Question objects
    Question[] questionObjects = new Question[10];
    int iterator = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");

        userName = findViewById(R.id.user_name);
        questionNumberText = findViewById(R.id.question_number);
        questionText = findViewById(R.id.question_text);
        answerExample1 = findViewById(R.id.answer_example1);
        answerExample2 = findViewById(R.id.answer_example2);
        answerExample3 = findViewById(R.id.answer_example3);
        answerExample4 = findViewById(R.id.answer_example4);
        answerNone = findViewById(R.id.answer_none);

        //initialize array of Question objects
        questionObjects[0] = new Question(getResources().getString(R.string.q1), getResources().getString(R.string.q1text),
                getResources().getString(R.string.q1example1) ,getResources().getString(R.string.q1example2),
                getResources().getString(R.string.q1example3), getResources().getString(R.string.q1example4),
                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q1AgeRelated));
        questionObjects[1] = new Question(getResources().getString(R.string.q2), getResources().getString(R.string.q2text),
                getResources().getString(R.string.q2example1) ,getResources().getString(R.string.q2example2),
                getResources().getString(R.string.q2example3), getResources().getString(R.string.q2example4),
                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q2AgeRelated));
        questionObjects[2] = new Question(getResources().getString(R.string.q3), getResources().getString(R.string.q3text),
                getResources().getString(R.string.q3example1) ,getResources().getString(R.string.q3example2),
                getResources().getString(R.string.q3example3), getResources().getString(R.string.q3example4),
                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q3AgeRelated));
        questionObjects[3] = new Question(getResources().getString(R.string.q4), getResources().getString(R.string.q4text),
                getResources().getString(R.string.q4example1) ,getResources().getString(R.string.q4example2),
                getResources().getString(R.string.q4example3), getResources().getString(R.string.q4example4),
                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q4AgeRelated));
        questionObjects[4] = new Question(getResources().getString(R.string.q5), getResources().getString(R.string.q5text),
                getResources().getString(R.string.q5example1) ,getResources().getString(R.string.q5example2),
                getResources().getString(R.string.q5example3), getResources().getString(R.string.q5example4),
                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q5AgeRelated));
        questionObjects[5] = new Question(getResources().getString(R.string.q6), getResources().getString(R.string.q6text),
                getResources().getString(R.string.q6example1) ,getResources().getString(R.string.q6example2),
                getResources().getString(R.string.q6example3), getResources().getString(R.string.q6example4),
                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q6AgeRelated));
        questionObjects[6] = new Question(getResources().getString(R.string.q7), getResources().getString(R.string.q7text),
                getResources().getString(R.string.q7example1) ,getResources().getString(R.string.q7example2),
                getResources().getString(R.string.q7example3), getResources().getString(R.string.q7example4),
                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q7AgeRelated));
        questionObjects[7] = new Question(getResources().getString(R.string.q8), getResources().getString(R.string.q8text),
                getResources().getString(R.string.q8example1) ,getResources().getString(R.string.q8example2),
                getResources().getString(R.string.q8example3), getResources().getString(R.string.q8example4),
                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q8AgeRelated));
        questionObjects[8] = new Question(getResources().getString(R.string.q9), getResources().getString(R.string.q9text),
                getResources().getString(R.string.q9example1) ,getResources().getString(R.string.q9example2),
                getResources().getString(R.string.q9example3), getResources().getString(R.string.q9example4),
                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q9AgeRelated));
        questionObjects[9] = new Question(getResources().getString(R.string.q10), getResources().getString(R.string.q10text),
                getResources().getString(R.string.q10example1) ,getResources().getString(R.string.q10example2),
                getResources().getString(R.string.q10example3), getResources().getString(R.string.q10example4),
                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q10AgeRelated));

        //display name
        displayName(name);

        //show first question
        setQuestion();
    }

    //method sets each question object text value to the views for question in app
    public void setQuestion(){
        questionNumberText.setText(questionObjects[iterator].getQuestionNumber());
        questionText.setText(questionObjects[iterator].getQuestionText());
        answerExample1.setText(questionObjects[iterator].getAnswerExample1());
        answerExample2.setText(questionObjects[iterator].getAnswerExample2());
        answerExample3.setText(questionObjects[iterator].getAnswerExample3());
        answerExample4.setText(questionObjects[iterator].getAnswerExample4());
        answerNone.setText(questionObjects[iterator].getAnswerExampleNone());
    }

    //method to display name user provides
    private void displayName(String string){
        String empty = userName.getResources().getString(R.string.userName);
        empty += " " + string;
        userName.setText(empty);
    }

    //method to handle user's submitted response to questions
    public void submitAnswer(View view){
        boolean a1 = answerExample1.isChecked();
        boolean a2 = answerExample2.isChecked();
        boolean a3 = answerExample3.isChecked();
        boolean a4 = answerExample4.isChecked();
        boolean aNone = answerNone.isChecked();
        if (a1 || a2 || a3 || a4 || aNone) {
            if (aNone) {
                score += 0;
            } else {
                if (a1) {
                    score += POINT;
                }
                if (a2) {
                    score += POINT;
                }
                if (a3) {
                    score += POINT;
                }
                if (a4) {
                    score += POINT;
                }
            }
            if (iterator < questionObjects.length - 1) {
                //shows custom message after each selection
                Toast.makeText(this, this.questionObjects[iterator].getToastMessage(), Toast.LENGTH_LONG).show();
                iterator += POINT;
                setQuestion();
            } else if (iterator == questionObjects.length - 1){
                //shows final custom message after selection
                Toast.makeText(this, this.questionObjects[iterator].getToastMessage(), Toast.LENGTH_LONG).show();
                Intent intent = new Intent(QuestionActivity.this, ResultsActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("score", score);
                startActivity(intent);

            }
            //clears all checkboxes
            checkboxReset();
        }else {
            Toast.makeText(this, this.getResources().getString(R.string.mustAnswer), Toast.LENGTH_LONG).show();
        }
    }

    //helper method to reset all checkbox booleans to false
    private void checkboxReset(){
        answerExample1.setChecked(false);
        answerExample2.setChecked(false);
        answerExample3.setChecked(false);
        answerExample4.setChecked(false);
        answerNone.setChecked(false);
    }
}
