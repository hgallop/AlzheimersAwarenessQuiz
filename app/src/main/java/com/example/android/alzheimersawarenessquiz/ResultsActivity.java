package com.example.android.alzheimersawarenessquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {

    static final String NAME = "name";
    static final String SCORE = "score";

    //variable for view that holds score information
    private TextView scoreView;
    //variable for view that allows user to choose to send an email with score information
    private RadioButton yesButton;

    //variable to store name given by user in welcome screen
    String name;

    //variable to store score for all questions
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        //retrieves information from previous activities
        Intent intent = getIntent();
        //gets name user entered in welcome screen
        name = intent.getStringExtra(NAME);
        //gets score calculated from quiz questions activity
        score = intent.getIntExtra(SCORE, 0);

        //initialize variable for view that holds score information
        scoreView = findViewById(R.id.score_view);
        //initialize variable for view that allows user to choose to send an email with score information
        yesButton = findViewById(R.id.yes);

        //updates score message
        scoreMessage(score);
    }

    //saves state of app variables for screen rotation.
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(NAME, name);
        outState.putInt(SCORE, score);
    }

    //restores state of app variables for screen rotation.
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        name = savedInstanceState.getString(NAME);
        score = savedInstanceState.getInt(SCORE);
    }

    //method to show score in app
    private void scoreMessage(int score) {
        String message = getResources().getString(R.string.scoreMessage);
        String message2 = getResources().getString(R.string.scoreMessage2);
        message += " " + score + " " + message2;
        scoreView.setText(message);
    }

    //method to handle radio button choice and launch email if user answers yes
    public void submitRadio(View view) {
        //variable to check radio nutton response
        boolean yes = yesButton.isChecked();
        if (yes) {
            //generates strings for email subject and message
            String emailSubject = getResources().getString(R.string.summary_email_subject) + " " + name;
            String message = name + " " + getResources().getString(R.string.emailScore) + " ";
            String message2 = String.valueOf(score) + " " + getResources().getString(R.string.scoreMessage2);
            String message3 = getResources().getString(R.string.alzWebsite);
            String message4 = getResources().getString(R.string.disclaimerForLink);
            String message5 = getResources().getString(R.string.description);
            //create array of strings for email message
            String messages[] = {message, message2, message3, message4, message5};
            //creates string builder object to build string from array
            StringBuilder emailBody = new StringBuilder();
            //loop over array of messages and build a string from it
            for (String msg : messages) {
                emailBody.append(msg);
            }
            //creates intent to use email application to send email message
            Intent intent = new Intent(Intent.ACTION_SENDTO);
            intent.setData(Uri.parse("mailto:"));
            intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
            intent.putExtra(Intent.EXTRA_TEXT, emailBody.toString());
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            }
        } else {
            //message that displays to user if they chose not to generate an email
            Toast.makeText(this, this.getResources().getString(R.string.noEmail), Toast.LENGTH_SHORT).show();
        }
    }

    //method to handle opening website on click of button
    public void visitAlz(View view) {
        //sends intent to use web browser to launch address
        Intent openBrowser = new Intent(android.content.Intent.ACTION_VIEW);
        openBrowser.setData(Uri.parse("http://www.alz.org/10-signs-symptoms-alzheimers-dementia.asp"));
        startActivity(openBrowser);
    }

    //resets score message on click of button. sends user back to welcome screen
    public void resetQuiz(View view) {
        score = 0;
        scoreMessage(score);
        //intent to send user back to the welcome screen activity
        Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
