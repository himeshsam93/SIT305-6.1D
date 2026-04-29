package com.example.llmlearningapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.llmlearningapp.R;
import com.example.llmlearningapp.llm.LLMHelper;

public class TaskActivity extends AppCompatActivity {

    TextView hintText, promptText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);

        Button hintBtn = findViewById(R.id.hintBtn);
        Button submitBtn = findViewById(R.id.submitBtn);

        hintText = findViewById(R.id.hintText);
        promptText = findViewById(R.id.promptText);

        hintBtn.setOnClickListener(v -> {

            String prompt =
                    "Give a short learning hint for the question: What is AI?";

            promptText.setText("Prompt:\n" + prompt);

            // LOADING STATE
            hintText.setText("Loading AI response...");

            LLMHelper.askAI(prompt, new LLMHelper.LLMCallback() {

                @Override
                public void onSuccess(String response) {

                    runOnUiThread(() ->
                            hintText.setText("AI Response:\n\n" + response)
                    );
                }

                @Override
                public void onError(String error) {

                    runOnUiThread(() ->
                            hintText.setText("Failed:\n" + error)
                    );
                }
            });
        });

        submitBtn.setOnClickListener(v -> {
            startActivity(
                    new Intent(TaskActivity.this,
                            ResultActivity.class)
            );
        });
    }
}
