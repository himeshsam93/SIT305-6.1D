package com.example.llmlearningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.llmlearningapp.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        LinearLayout taskCard = findViewById(R.id.taskCard);

        taskCard.setOnClickListener(v ->
                startActivity(new Intent(this, TaskActivity.class)));
    }
}
