package com.example.android.alzheimersawarenessquiz;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {

    private TextView scoreView;
    private RadioButton yesButton;

    String name;
    int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        score = intent.getIntExtra("score", 0);

        scoreView = findViewById(R.id.score_view);
        yesButton = findViewById(R.id.yes);

        //updates score message
        scoreMessage(score);
    }

    //method to show score in app
    private void scoreMessage(int score){
        String message = getResources().getString(R.string.scoreMessage);
        String message2 = getResources().getString(R.string.scoreMessage2);
        message += " " + score + " " + message2;
        scoreView.setText(message);
    }

    //method to handle radio button choice and launch email if user answers yes
    public void submitRadio(View view){
        boolean yes = yesButton.isChecked();
        if (yes){
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

    public void resetQuiz(View view){
        score = 0;
        scoreMessage(score);
        Intent intent = new Intent(ResultsActivity.this, MainActivity.class);
        startActivity(intent);

    }
}
