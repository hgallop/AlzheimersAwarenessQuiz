package com.example.android.alzheimersawarenessquiz;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

public class QuestionActivity extends AppCompatActivity {

    //create string keys
    static final String NAME = "name";
    static final String SCORE = "score";
    static final String QUESTION_INDEX = "questionIndex";

    //variables for all views that will hold question information
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

    //create variables to hold state of each checkbox
    boolean a1;
    boolean a2;
    boolean a3;
    boolean a4;
    boolean aNone;

    //create variable for scoring a point
    final int POINT = 1;
    //create variable for the number of questions
    final int NUMBER_OF_QUESTIONS = 10;

    //create and initialize a variable for score.
    int score = 0;

    //declare an array of Question objects
    Question[] questionObjects = new Question[NUMBER_OF_QUESTIONS];

    //iterator for question display
    int questionIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        //retrieves name information from welcome screen to display message to user.
        Intent intent = getIntent();
        name = intent.getStringExtra(NAME);

        //initializes all variables for views that hold question information
        userName = findViewById(R.id.user_name);
        questionNumberText = findViewById(R.id.question_number);
        questionText = findViewById(R.id.question_text);
        answerExample1 = findViewById(R.id.answer_example1);
        answerExample2 = findViewById(R.id.answer_example2);
        answerExample3 = findViewById(R.id.answer_example3);
        answerExample4 = findViewById(R.id.answer_example4);
        answerNone = findViewById(R.id.answer_none);

        //display user's name
        displayName(name);

        //generate questions
        generateQuestions();

        //show first question
        setQuestion();

        //listens for user to click none
        answerNone.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                //checks state of checkboxes
                checkBooleans();
                //checks for any checkbox that is checked
                if (a1 || a2 || a3 || a4){
                    //resets all other checkboxes
                    answerExample1.setChecked(false);
                    answerExample2.setChecked(false);
                    answerExample3.setChecked(false);
                    answerExample4.setChecked(false);
                }
            }
        });
    }

    //saves state of app variables for screen rotation.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(NAME, name);
        outState.putInt(SCORE, score);
        outState.putInt(QUESTION_INDEX, questionIndex);
    }

    //restores state of app variables for screen rotation.
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        name = savedInstanceState.getString(NAME);
        score = savedInstanceState.getInt(SCORE);
        questionIndex = savedInstanceState.getInt(QUESTION_INDEX);
        //call methods that create and set questions
        generateQuestions();
        setQuestion();
    }

    //builds question object array.
    //Rex Sikora (fellow GwG scholar) contributed to this method.
    private void generateQuestions() {
        int noneResponseId = getResources().getIdentifier("noneResponse", "string", getPackageName());
        String noneResponseText = getResources().getString(noneResponseId);

        for (int i = 0; i < NUMBER_OF_QUESTIONS; i++) {
            int questionId = getResources().getIdentifier("q" + (i + 1), "string", getPackageName());
            int textId = getResources().getIdentifier("q" + (i + 1) + "text", "string", getPackageName());
            int example1Id = getResources().getIdentifier("q" + (i + 1) + "example1", "string", getPackageName());
            int example2Id = getResources().getIdentifier("q" + (i + 1) + "example2", "string", getPackageName());
            int example3Id = getResources().getIdentifier("q" + (i + 1) + "example3", "string", getPackageName());
            int example4Id = getResources().getIdentifier("q" + (i + 1) + "example4", "string", getPackageName());
            int ageRelatedId = getResources().getIdentifier("q" + (i + 1) + "AgeRelated", "string", getPackageName());
            String question = getResources().getString(questionId);
            String text = getResources().getString(textId);
            String example1 = getResources().getString(example1Id);
            String example2 = getResources().getString(example2Id);
            String example3 = getResources().getString(example3Id);
            String example4 = getResources().getString(example4Id);
            String ageRelatedText = getResources().getString(ageRelatedId);
            questionObjects[i] = new Question(question, text, example1, example2, example3, example4, noneResponseText, ageRelatedText);
        }
    }

    //method sets each question object text value to the views for question in app
    public void setQuestion(){
        questionNumberText.setText(questionObjects[questionIndex].getQuestionNumber());
        questionText.setText(questionObjects[questionIndex].getQuestionText());
        answerExample1.setText(questionObjects[questionIndex].getAnswerExample1());
        answerExample2.setText(questionObjects[questionIndex].getAnswerExample2());
        answerExample3.setText(questionObjects[questionIndex].getAnswerExample3());
        answerExample4.setText(questionObjects[questionIndex].getAnswerExample4());
        answerNone.setText(questionObjects[questionIndex].getAnswerExampleNone());
    }

    //method to personalized greeting to user
    private void displayName(String string){
        String greeting = userName.getResources().getString(R.string.userGreeting) + " " + string;
        userName.setText(greeting);
    }

    //method to handle user's submitted response to questions
    public void submitAnswer(View view){
        //check the state of all checkboxes
        checkBooleans();
        //ensures user chose at least one option
        if (a1 || a2 || a3 || a4 || aNone) {
            //adds no score if user answered none
            if (aNone) {
                score += 0;
            //adds one point for each option checked if the chose options and not none
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
            //ensures question index is less than length of object array
            if (questionIndex < questionObjects.length - 1) {
                //shows custom message after each selection
                Toast.makeText(this, this.questionObjects[questionIndex].getToastMessage(), Toast.LENGTH_LONG).show();
                //increases the question index
                questionIndex += POINT;
                //shows next question
                setQuestion();
            //handles the last question
            } else if (questionIndex == questionObjects.length - 1){
                //shows final custom message after selection
                Toast.makeText(this, this.questionObjects[questionIndex].getToastMessage(), Toast.LENGTH_LONG).show();
                //send user to results activity
                Intent intent = new Intent(QuestionActivity.this, ResultsActivity.class);
                //sends name and score information to results activity
                intent.putExtra("name", name);
                intent.putExtra("score", score);
                startActivity(intent);

            }
            //clears all checkboxes
            checkboxReset();
        }else {
            //message to inform user to make at least one selection.
            Toast.makeText(this, this.getResources().getString(R.string.mustAnswer), Toast.LENGTH_LONG).show();
        }
    }

    //helper method that checks state of all checkboxes
    private void checkBooleans(){
        a1 = answerExample1.isChecked();
        a2 = answerExample2.isChecked();
        a3 = answerExample3.isChecked();
        a4 = answerExample4.isChecked();
        aNone = answerNone.isChecked();
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
