package com.example.android.alzheimersawarenessquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText nameText;
    private TextView userName;
    private Button questionOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.name_text);
        userName = findViewById(R.id.user_name);
        questionOne = findViewById(R.id.question_one);
    }



    private void displayName(String string){
            String empty = userName.getResources().getString(R.string.userName);
            empty += " " + string;
            userName.setText(empty);
    }

    public void nameText(View view) {
        String name = nameText.getText().toString();
        displayName(name);
        Toast.makeText(this, this.getString(R.string.toastScroll), Toast.LENGTH_SHORT).show();
    }


}
