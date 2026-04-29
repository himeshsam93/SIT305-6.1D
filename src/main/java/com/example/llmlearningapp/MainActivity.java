package com.example.llmlearningapp;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.llmlearningapp.activities.LoginActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Open Login Screen
        startActivity(new Intent(MainActivity.this, LoginActivity.class));

        // Close MainActivity
        finish();
    }
}