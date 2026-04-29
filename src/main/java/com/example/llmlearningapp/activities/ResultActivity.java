package com.example.llmlearningapp.activities;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.llmlearningapp.R;
import com.example.llmlearningapp.llm.LLMHelper;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Button explainBtn = findViewById(R.id.explainBtn);

        TextView explanationText =
                findViewById(R.id.explanationText);

        explainBtn.setOnClickListener(v -> {

            String prompt =
                    "Explain why AI stands for Artificial Intelligence.";

            explanationText.setText("Loading...");

            LLMHelper.askAI(prompt,
                    new LLMHelper.LLMCallback() {

                        @Override
                        public void onSuccess(String response) {

                            runOnUiThread(() ->
                                    explanationText.setText(response)
                            );
                        }

                        @Override
                        public void onError(String error) {

                            runOnUiThread(() ->
                                    explanationText.setText(error)
                            );
                        }
                    });
        });
    }
}
