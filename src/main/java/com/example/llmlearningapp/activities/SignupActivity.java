package com.example.llmlearningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.llmlearningapp.R;
import com.example.llmlearningapp.database.*;

public class SignupActivity extends AppCompatActivity {

    EditText username, password;
    Button createBtn;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        createBtn = findViewById(R.id.createBtn);

        db = AppDatabase.getInstance(this);

        createBtn.setOnClickListener(v -> {
            User user = new User();
            user.username = username.getText().toString();
            user.password = password.getText().toString();

            db.userDao().insert(user);

            startActivity(new Intent(this, InterestsActivity.class));
        });
    }
}
