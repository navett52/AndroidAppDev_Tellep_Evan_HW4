package com.example.tellep_evan_hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    EditText name_input, email_input, password_input;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.name) instanceof EditText) {
            name_input = findViewById(R.id.name);
        }

        if (findViewById(R.id.email) instanceof EditText) {
            email_input = findViewById(R.id.email);
        }

        if (findViewById(R.id.password) instanceof EditText) {
            password_input = findViewById(R.id.password);
        }

        findViewById(R.id.save).setOnClickListener(onSaveButtonClick);
        findViewById(R.id.retrieve).setOnClickListener(onRetrieveButtonClick);
        findViewById(R.id.clear).setOnClickListener(onClearButtonClick);
    }

    private View.OnClickListener onSaveButtonClick = (v) -> {
        SharedPreferences sharedpreferences = getSharedPreferences("EvansPreferences", Context.MODE_PRIVATE);
        String name = "";
        String email = "";
        String password = "";

        name = name_input.getText().toString();
        email = email_input.getText().toString();
        password = password_input.getText().toString();

        SharedPreferences.Editor editor = sharedpreferences.edit();

        editor.putString("name", name);
        editor.putString("email", email);
        editor.putString("password", password);

        editor.commit();
    };

    private View.OnClickListener onRetrieveButtonClick = (v) -> {
        SharedPreferences sharedpreferences = getSharedPreferences("EvansPreferences", Context.MODE_PRIVATE);

        name_input.setText(sharedpreferences.getString("name", null));
        email_input.setText(sharedpreferences.getString("email", null));
        password_input.setText(sharedpreferences.getString("password", null));
    };

    private View.OnClickListener onClearButtonClick = (v) -> {
        name_input.setText("");
        email_input.setText("");
        password_input.setText("");
    };
}
