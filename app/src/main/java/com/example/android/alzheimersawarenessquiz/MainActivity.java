package com.example.android.alzheimersawarenessquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    //creates string key for intent extra
    static final String NAME = "name";

    //declare variables for all views that handle events
    private EditText nameText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variables for all views that handle events
        nameText = findViewById(R.id.name_text);
        Button submitName = findViewById(R.id.submit_name);

        //launches question activity when name is submitted using button. sends name information entered by the user to the question activity.
        submitName.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                intent.putExtra(NAME, nameText.getText().toString());
                startActivity(intent);
                //clears edit text field
                nameText.getText().clear();

            }
        });
    }
}
