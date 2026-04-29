package com.example.llmlearningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import com.example.llmlearningapp.R;
import com.example.llmlearningapp.database.*;
import com.example.llmlearningapp.utils.SessionManager;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button loginBtn;
    TextView signupLink;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        loginBtn = findViewById(R.id.loginBtn);
        signupLink = findViewById(R.id.signupLink);

        db = AppDatabase.getInstance(this);

        loginBtn.setOnClickListener(v -> {
            User user = db.userDao().login(
                    username.getText().toString(),
                    password.getText().toString()
            );

            if (user != null) {
                SessionManager.login(this, user.username);
                startActivity(new Intent(this, HomeActivity.class));
            } else {
                Toast.makeText(this, "Invalid Login", Toast.LENGTH_SHORT).show();
            }
        });

        signupLink.setOnClickListener(v ->
                startActivity(new Intent(this, SignupActivity.class)));
    }
}
