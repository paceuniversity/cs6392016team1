package com.ronyalvarez.eventage;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class MainScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        final TextView tvWelcomeMessage = (TextView) findViewById(R.id.tvWelcomeMessage);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");

        String message = "Hello ";
        message = message.concat(name);
        message = message.concat(", welcome to your user area!");

        tvWelcomeMessage.setText(message);

    }
}
