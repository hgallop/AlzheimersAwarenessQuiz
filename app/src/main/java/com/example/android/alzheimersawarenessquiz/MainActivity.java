package com.example.android.alzheimersawarenessquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declare variables for all views that will change.
    private EditText nameText;
    private TextView userName;
    private TextView questionNumberText;
    private TextView questionText;
    private CheckBox answerExample1;
    private CheckBox answerExample2;
    private CheckBox answerExample3;
    private CheckBox answerExample4;
    private CheckBox answerNone;
    private TextView scoreView;
    private RadioButton yesButton;

    //declare an array of Question objects
    Question[] questionObjects = new Question[10];

    // Not a fan (for readability) perhaps questionIndex works better
    int iterator = 0;

    //create variables for score and point
    final int POINT = 1;
    int score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variables for all views
        nameText = findViewById(R.id.name_text);
        userName = findViewById(R.id.user_name);
        questionNumberText = findViewById(R.id.question_number);
        questionText = findViewById(R.id.question_text);
        answerExample1 = findViewById(R.id.answer_example1);
        answerExample2 = findViewById(R.id.answer_example2);
        answerExample3 = findViewById(R.id.answer_example3);
        answerExample4 = findViewById(R.id.answer_example4);
        answerNone = findViewById(R.id.answer_none);
        scoreView = findViewById(R.id.score_view);
        yesButton = findViewById(R.id.yes);

        //initialize array of Question objects
        // This would be better off in it's own class.
//        questionObjects[0] = new Question(getResources().getString(R.string.q1), getResources().getString(R.string.q1text),
//                getResources().getString(R.string.q1example1) ,getResources().getString(R.string.q1example2),
//                getResources().getString(R.string.q1example3), getResources().getString(R.string.q1example4),
//                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q1AgeRelated));
//        questionObjects[1] = new Question(getResources().getString(R.string.q2), getResources().getString(R.string.q2text),
//                getResources().getString(R.string.q2example1) ,getResources().getString(R.string.q2example2),
//                getResources().getString(R.string.q2example3), getResources().getString(R.string.q2example4),
//                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q2AgeRelated));
//        questionObjects[2] = new Question(getResources().getString(R.string.q3), getResources().getString(R.string.q3text),
//                getResources().getString(R.string.q3example1) ,getResources().getString(R.string.q3example2),
//                getResources().getString(R.string.q3example3), getResources().getString(R.string.q3example4),
//                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q3AgeRelated));
//        questionObjects[3] = new Question(getResources().getString(R.string.q4), getResources().getString(R.string.q4text),
//                getResources().getString(R.string.q4example1) ,getResources().getString(R.string.q4example2),
//                getResources().getString(R.string.q4example3), getResources().getString(R.string.q4example4),
//                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q4AgeRelated));
//        questionObjects[4] = new Question(getResources().getString(R.string.q5), getResources().getString(R.string.q5text),
//                getResources().getString(R.string.q5example1) ,getResources().getString(R.string.q5example2),
//                getResources().getString(R.string.q5example3), getResources().getString(R.string.q5example4),
//                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q5AgeRelated));
//        questionObjects[5] = new Question(getResources().getString(R.string.q6), getResources().getString(R.string.q6text),
//                getResources().getString(R.string.q6example1) ,getResources().getString(R.string.q6example2),
//                getResources().getString(R.string.q6example3), getResources().getString(R.string.q6example4),
//                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q6AgeRelated));
//        questionObjects[6] = new Question(getResources().getString(R.string.q7), getResources().getString(R.string.q7text),
//                getResources().getString(R.string.q7example1) ,getResources().getString(R.string.q7example2),
//                getResources().getString(R.string.q7example3), getResources().getString(R.string.q7example4),
//                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q7AgeRelated));
//        questionObjects[7] = new Question(getResources().getString(R.string.q8), getResources().getString(R.string.q8text),
//                getResources().getString(R.string.q8example1) ,getResources().getString(R.string.q8example2),
//                getResources().getString(R.string.q8example3), getResources().getString(R.string.q8example4),
//                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q8AgeRelated));
//        questionObjects[8] = new Question(getResources().getString(R.string.q9), getResources().getString(R.string.q9text),
//                getResources().getString(R.string.q9example1) ,getResources().getString(R.string.q9example2),
//                getResources().getString(R.string.q9example3), getResources().getString(R.string.q9example4),
//                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q9AgeRelated));
//        questionObjects[9] = new Question(getResources().getString(R.string.q10), getResources().getString(R.string.q10text),
//                getResources().getString(R.string.q10example1) ,getResources().getString(R.string.q10example2),
//                getResources().getString(R.string.q10example3), getResources().getString(R.string.q10example4),
//                getResources().getString(R.string.noneResponse), getResources().getString(R.string.q10AgeRelated));

        //generate questions
        generateQuestions();
        //show first question
        setQuestion();

    }


    // You could build everything out programmatically which if you had a 100 questions would be far less code.
    private void generateQuestions() {
        int noneResponseId = getResources().getIdentifier("noneResponse", "string", getPackageName());
        String noneResponseText = getResources().getString(noneResponseId);

        for (int i =0; i < 10; i++) {
            int questionId = getResources().getIdentifier("q" + (i+1), "string", getPackageName());
            int textId = getResources().getIdentifier("q" + (i+1) + "text", "string", getPackageName());
            int example1Id = getResources().getIdentifier("q" + (i+1) + "example1", "string", getPackageName());
            int example2Id = getResources().getIdentifier("q" + (i+1) + "example2", "string", getPackageName());
            int example3Id = getResources().getIdentifier("q" + (i+1) + "example3", "string", getPackageName());
            int example4Id = getResources().getIdentifier("q" + (i+1) + "example4", "string", getPackageName());
            int ageRelatedId = getResources().getIdentifier("q" + (i+1) + "AgeRelated", "string", getPackageName());
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

    //method to show score in app
    private void scoreMessage(int score){
        String message = getResources().getString(R.string.scoreMessage);
        String message2 = getResources().getString(R.string.scoreMessage2);
        message += " " + score + " " + message2;
        scoreView.setText(message);
    }

    //method to handle name submission
    public void nameText(View view) {
        String name = nameText.getText().toString();
        displayName(name);
        Toast.makeText(this, this.getString(R.string.toastScroll), Toast.LENGTH_SHORT).show();
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
            //updates score message
            scoreMessage(score);
            if (iterator < questionObjects.length - 1) {
                //shows custom message after each selection
                Toast.makeText(this, this.questionObjects[iterator].getToastMessage(), Toast.LENGTH_LONG).show();
                iterator += POINT;
                setQuestion();
            } else if (iterator == questionObjects.length - 1){
                //shows final custom message after selection
                Toast.makeText(this, this.questionObjects[iterator].getToastMessage(), Toast.LENGTH_LONG).show();
            }
            //clears all checkboxes
            checkboxReset();
        }else {
            Toast.makeText(this, this.getResources().getString(R.string.mustAnswer), Toast.LENGTH_LONG).show();
        }
    }

    //method to handle radio button choice and launch email if user answers yes
    public void submitRadio(View view){
        boolean yes = yesButton.isChecked();
        if (yes){
            String name = nameText.getText().toString();
            String emailSubject = getResources().getString(R.string.summary_email_subject);
            emailSubject += " " + name;
            String message = name + " " + getResources().getString(R.string.emailScore);
            String message2 = getResources().getString(R.string.scoreMessage2);
            String message3 = getResources().getString(R.string.alzWebsite);
            String message4 = getResources().getString(R.string.disclaimerForLink);
            String message5 = getResources().getString(R.string.description);
            message += " " + score + " " + message2 + message3 + message4 + "\n\n" + message5;
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
            intent.putExtra(Intent.EXTRA_TEXT, message);
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        } else {
            Toast.makeText(this, this.getResources().getString(R.string.noEmail), Toast.LENGTH_SHORT).show();
        }
    }

    //method to handle opening website on click
    public void visitAlz(View view) {
        Intent webOpen = new Intent(android.content.Intent.ACTION_VIEW);
        webOpen.setData(Uri.parse("http://www.alz.org/10-signs-symptoms-alzheimers-dementia.asp"));
        startActivity(webOpen);
    }

    //helper method to reset all checkbox booleans to false
    private void checkboxReset(){
        answerExample1.setChecked(false);
        answerExample2.setChecked(false);
        answerExample3.setChecked(false);
        answerExample4.setChecked(false);
        answerNone.setChecked(false);
    }

    public void resetQuiz(View view){
        checkboxReset();
        iterator = 0;
        score = 0;
        String empty = userName.getResources().getString(R.string.userName);
        empty += " ";
        userName.setText(empty);
        nameText.getText().clear();
        setQuestion();
        scoreMessage(score);
    }

}

/**
 * Overall Notes:
 * XML:
 *      - Missing input type in your EditView
 *
 * JAVA:
 *      - Create a questionbank and move the model out of the controller
 *      - Revisit some of your variable names (most of it looks good!)
 *      - If you are going to keep the questions in here, build out the array programmatically
 *        I've given you an example to look at.
 *      - I would break the UI into a few intents.  A user can just scroll down to the bottom.
 *        As a result you lose control of the funnel.  3 would be perfect for what you're doing.
 *      - More comments wouldn't hurt, but things are coming along!
 *
 *
 */
