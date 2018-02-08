package com.example.android.alzheimersawarenessquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText nameText;
    private TextView userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameText = findViewById(R.id.name_text);
        userName = findViewById(R.id.user_name);
    }



    private void displayName(String string){
            String empty = userName.getResources().getString(R.string.userName);
            empty += " " + string;
            userName.setText(empty);
    }

    public void nameText(View view) {
        String name = nameText.getText().toString();
        displayName(name);
    }
}
