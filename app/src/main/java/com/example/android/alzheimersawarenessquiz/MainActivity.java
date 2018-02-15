package com.example.android.alzheimersawarenessquiz;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //declare variables for all views that handle events
    private EditText nameText;
    private Button submitName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize variables for all views that handle events
        nameText = findViewById(R.id.name_text);
        submitName = findViewById(R.id.submit_name);

        submitName.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                intent.putExtra("name", nameText.getText().toString());
                startActivity(intent);
                nameText.getText().clear();

            }
        });
    }
}
