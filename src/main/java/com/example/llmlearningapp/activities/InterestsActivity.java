package com.example.llmlearningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.example.llmlearningapp.R;

public class InterestsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_interests);

        Button nextBtn = findViewById(R.id.nextBtn);

        nextBtn.setOnClickListener(v ->
                startActivity(new Intent(this, HomeActivity.class)));
    }
}
